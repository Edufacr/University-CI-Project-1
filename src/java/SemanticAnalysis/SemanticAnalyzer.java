package SemanticAnalysis;
import java.util.ArrayList;

import CodeGeneration.CodeGenerator;
import SemanticAnalysis.SemanticStackM.*;
import SemanticAnalysis.SemanticStackM.Registers.*;
import SemanticAnalysis.SymbolTableM.*;

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
    
    @Override
    public void saveType(String pType, int pLine, int pCol) {
        SemanticRegister register = new TypeRegister(pType,pLine,pCol);
        stack.push(register);
    }

    @Override
    public void saveIdentifier(String pIdentifier, int pLine, int pCol) {

        SemanticRegister register = new IdRegister(pIdentifier,pLine,pCol);
        stack.push(register);
        
        String printing = stack.toString();
        System.out.println(printing);
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
    public void saveFooDecl() {
        IdRegister idRegister = (IdRegister) stack.pop();
        TypeRegister typeRegister = (TypeRegister) stack.pop();

        FuncRegister funcRegister = new FuncRegister(typeRegister.getType(), idRegister.getId());
        stack.push(funcRegister);
        
        if((table.isDefined(idRegister.getId()))){
            printError("Function: " + idRegister.getId() + " in line: "+ (idRegister.getLine() + 1) + ", in column: " + (idRegister.getColumn() + 1) + " is already defined."); 
        }
        
           

        String printing = stack.toString();
        System.out.println(printing);

    }

    @Override
    public void insertFooDecl() {

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
    public void checkVar(String pIdentifier, int pLine, int pCol){
        if(!(table.isDefined(pIdentifier))){
            printError("Variable: " + pIdentifier + " in line: "+ (pLine + 1) + ", in column: " + (pCol + 1) + " is undefined."); 
        }
    }

    @Override
    public void checkFunc(String pIdentifier, int pLine, int pCol) {
        if(!(table.isDefined(pIdentifier))){
            printError("Variable: " + pIdentifier + " in line: "+ (pLine + 1) + ", in column: " + (pCol + 1) + " is undefined."); 
        }
    }
}
