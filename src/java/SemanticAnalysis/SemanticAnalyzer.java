package SemanticAnalysis;
import java.util.ArrayList;

import CodeGeneration.CodeGenerator;
import SemanticAnalysis.SemanticStackM.*;
import SemanticAnalysis.SymbolTableM.*;
import SemanticAnalysis.SemanticStackM.Registers.*;
import SemanticAnalysis.SemanticStackM.Registers.DO_Registers.DataObject;

public class SemanticAnalyzer implements ISemanticAnalyzer{

    private SemanticStack stack;
    private SymbolTable   table;
    private CodeGenerator codeGen;

    public SemanticAnalyzer(){
        this.stack = new SemanticStack();
        this.table = new SymbolTable();
        this.codeGen = new CodeGenerator();
    }

    private void printError(String pMessage){
        System.out.println("Semantic Error: ");
        System.out.println(pMessage);
        System.out.println();
    }

    public void printSymbolTable(){
        table.print();
    }

    public void printSemanticStack(){
        System.out.println(stack.toString());
    }
    
    @Override
    public void saveType(String pType, int pLine, int pCol) {
        SemanticRegister register = new TypeRegister(pType,pLine,pCol);
        stack.push(register);
    }

    @Override
    public void saveIdentifier(String pIdentifier, int pLine, int pCol) {

        SemanticRegister register = new IdRegister(pIdentifier,pLine,pCol);
        stack.push(register);
    }

    @Override
    public void insertVar() {
        TypeRegister type = (TypeRegister) stack.findRegister(TypeRegister.class);

        while(!(stack.peek() instanceof TypeRegister)){
            IdRegister identifier = (IdRegister) stack.pop();

            if(!(table.isDefined(identifier.getId()))){
                VarSymbol symbol = new VarSymbol(identifier.getId(), type.getType());
                table.insertSymbol(identifier.getId(), symbol);
                codeGen.generateGlobalVarCode(symbol.getName(), symbol.getType());

            } else {
                printError("Identifier: " + identifier.getId() + " in line: "+ (identifier.getLine() + 1) + ", in column: " + (identifier.getColumn() + 1) + " is already defined.");
            }
        }

        stack.pop();
    }

    @Override
    public void endOfCode() {
        System.out.println("EndOfCode");
        codeGen.commitDataSegment();
        codeGen.commitCodeSegment();   
        codeGen.generateFile();
        printSymbolTable();
    }

    @Override
    public void completeVarDecls() {
        codeGen.commitDataSegment();
    }

    @Override
    public void saveFuncDecl() {
        IdRegister idRegister = (IdRegister) stack.pop();
        TypeRegister typeRegister = (TypeRegister) stack.pop();

        FuncRegister funcRegister = new FuncRegister(typeRegister.getType(), idRegister.getId());
        stack.push(funcRegister);
        
        if((table.isDefined(idRegister.getId()))){
            printError("Function: " + idRegister.getId() + " in line: "+ (idRegister.getLine() + 1) + ", in column: " + (idRegister.getColumn() + 1) + " is already defined."); 
        }
    }

    @Override
    public void insertFuncDecl() {

        ArrayList<VarSymbol> params = new ArrayList<>();

        while(!(stack.peek() instanceof FuncRegister)){
            IdRegister idRegister = (IdRegister) stack.pop();
            TypeRegister typeRegister = (TypeRegister) stack.pop();

            VarSymbol symbol = new VarSymbol(idRegister.getId(), typeRegister.getType());
            
            params.add(symbol);
            
        }

        FuncRegister funcRegister = (FuncRegister) stack.pop();

        FuncSymbol funcSymbol = new FuncSymbol(funcRegister.getName(), funcRegister.getType(), params);
        
        table.insertSymbol(funcRegister.getName(), funcSymbol);
    }

    @Override
    public void saveFuncCall(String pIdentifier, int pLine, int pCol) {
        SemanticRegister register = new FuncCallRegister(pIdentifier, pLine, pCol);
        stack.push(register);
    }

    @Override
    public void checkVar(String pIdentifier, int pLine, int pCol){
        if(!(table.isDefined(pIdentifier))){
            printError("Variable: " + pIdentifier + " in line: "+ (pLine + 1) + ", in column: " + (pCol + 1) + " is undefined."); 
            Symbol symbol = new ErrorSymbol(pIdentifier);
            table.insertSymbol(pIdentifier, symbol);
        }
    }

    @Override
    public void checkFunc(String pIdentifier, int pLine, int pCol) {

        if(!(table.isDefined(pIdentifier))){
            printError("Function:  " + pIdentifier + " in line: "+ (pLine + 1) + ", in column: " + (pCol + 1) + " is undefined."); 
            Symbol symbol = new ErrorSymbol(pIdentifier);
            table.insertSymbol(pIdentifier, symbol);
        }

        Symbol symbol = table.getSymbol(pIdentifier);


        ArrayList<DataObject> inParams = new ArrayList<>();

        while(!(stack.peek() instanceof FuncCallRegister)){
            DataObject do_rs = (DataObject) stack.pop();
            inParams.add(0, do_rs);
        }

        stack.pop();

        if(!(symbol instanceof ErrorSymbol)) {
            FuncSymbol funcSymbol =  (FuncSymbol) symbol;
            ArrayList<VarSymbol> params = funcSymbol.getParameters();

            if(params.size() != inParams.size()) {
                printError("Mismatch number of parameters in function: " + pIdentifier + " in line: "+ (pLine + 1) + ", in column: " + (pCol + 1) + " expected: " + params.size() + " got: " + inParams.size()); 
            } else {
                for (int i = 0; i < params.size(); i++) {
                    if (params.get(i).getType() != inParams.get(i).getType()) {
                        String errorMessage = "Mismatch parameter type in function: " + pIdentifier + " in line: "+ (pLine + 1) + ", in column: " + (pCol + 1)+
                        "Parameter: " + params.get(i).getName() + " is of type: " + params.get(i).getType() + "but got type: " + inParams.get(i).getType();
                        printError(errorMessage); 
                    }
                }
            }

        }
    }

}
