package SemanticAnalysis;
import java.util.ArrayList;

import CodeGeneration.CodeGenerator;
import SemanticAnalysis.SemanticStackM.*;
import SemanticAnalysis.SemanticStackM.Registers.DO_Registers.*;
import SemanticAnalysis.SymbolTableM.*;
import SemanticAnalysis.SemanticStackM.Registers.*;
import SemanticAnalysis.SemanticStackM.Registers.DO_Registers.DataObject;

public class SemanticAnalyzer implements ISemanticAnalyzer{

    private SemanticStack stack;
    private SymbolTable   table;
    private CodeGenerator codeGen;
    private int globalHelperVarCounter        = 0;
    private int globalHelperWhileLabelCounter = 0;
    private int globalHelperIfLabelCounter    = 0;

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

            // TODO: Preguntarle a la profe si los parametros son globales
            table.insertSymbol(idRegister.getId(), symbol);
            params.add(symbol);
            
        }

        FuncRegister funcRegister = (FuncRegister) stack.pop();

        FuncSymbol funcSymbol = new FuncSymbol(funcRegister.getName(), funcRegister.getType(), params);
        
        table.insertSymbol(funcRegister.getName(), funcSymbol);

        params.forEach(param -> codeGen.generateGlobalVarCode(param.getName(), param.getType()));

        //codeGen.generateOpenProc(funcSymbol, params);
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

    // TODO: Probar con el DO
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
                        " Parameter: " + params.get(i).getName() + " is of type: " + params.get(i).getType() + " but got type: " + inParams.get(i).getType();
                        printError(errorMessage); 
                    }
                }
            }

        }
    }

    @Override
    public void addConstInt(String constVal) {
        DO_ConstInt intDO = new DO_ConstInt(Integer.parseInt(constVal), "int");
        stack.push(intDO);
    }

    @Override
    public void addConstCharString(String charStringConst) {
        DO_ConstCharString charStringDO = new DO_ConstCharString(charStringConst, "String");
        stack.push(charStringDO);
    }

    // TODO: Preguntar a la profe si en la tabla de simbolos los simbolos de funccion tienen que ser diferentes a los de var
    // De esta manera se evitaría que se llame a una funcion como una varaibles
    @Override
    public void addExpressionVar(String var, int pLine, int pCol) {
        checkVar(var, pLine, pCol); //revisa que exista en la tabla de simbolos
        Symbol symbol = table.getSymbol(var);
        if(!(symbol instanceof ErrorSymbol)){
            DO_ExpressionVar expressionVarDO = new DO_ExpressionVar(var, (((VarSymbol) symbol).getType()));
            checkVar(var, pLine, pCol);
            stack.push(expressionVarDO);
            
        } else {
            //Error
        }
    }


    // TODO: Este es un Registro Semantico de operador no un DO
    // Por eso no tiene tipo como los demas DO
    @Override
    public void addOperator(String operator, int pLine, int pCol) {
        OperatorRegister operatorRegister = new OperatorRegister(operator, pLine, pCol);
        stack.push(operatorRegister);
    }

    @Override
    public void evalBinary(int pLine, int pCol) {
        printSemanticStack();
        DataObject rightDO = (DataObject) stack.pop();
        OperatorRegister op = (OperatorRegister) stack.pop();
        DataObject leftDO = (DataObject) stack.pop();

        if(!rightDO.getType().equals(leftDO.getType())){
            printError("Types do not match: " + rightDO.getToken() + " and "+ leftDO.getToken()+" in line: "+ (pLine + 1) + ", in column: " + (pCol + 1) + ".");
        } else {
//            if(rightDO instanceof DO_ConstInt && leftDO instanceof DO_ConstInt){
//
//            }
            String resultVarName = "tempVar"+globalHelperVarCounter;
            String codeBlock = codeGen.generateOperation(resultVarName, rightDO, leftDO, op);
            codeGen.addToCodeSegment(codeBlock);
            codeGen.generateGlobalVarCode(resultVarName, "");

            stack.push(new DO_ExpressionVar(resultVarName, leftDO.getType())); //add resulting do

            this.globalHelperVarCounter++;
        }


    }

    @Override
    public void evalUnary(int pLine, int pCol) {
        
    }

    @Override
    public void checkInLoop(String pIdentifier, int pLine, int pCol) {

        SemanticRegister loopRegister = stack.findRegister(WhileRegister.class);
        
        if(loopRegister == null){
            String errorMessage =  pIdentifier + " statement at line: " + pLine + " column: " + pCol + " is not within a loop or switch";
            printError(errorMessage); 
        }
    }

    @Override
    public void saveWhile(int pLine, int pCol) {
        String startLabel = "while_label_" + this.globalHelperWhileLabelCounter;
        String exitLabel = "exit_while_label_" + this.globalHelperWhileLabelCounter;

        this.globalHelperWhileLabelCounter++;
        
        SemanticRegister whileRegister = new WhileRegister(startLabel, exitLabel, pLine, pCol);

        codeGen.generateLabel(startLabel);

        stack.push(whileRegister);
    }

    @Override
    public void testWhile() {
        DataObject do1 = (DataObject) stack.pop();
        WhileRegister whileRegister = (WhileRegister) stack.findRegister(WhileRegister.class); 

        // TODO: Enum de tipos o revisar  
        if(!(do1.getType() == "Int")){ 
            String errorMessage = "Expression in while statement at line: " + whileRegister.getLine() + " column: " + whileRegister.getColumn() + "is not of type int" ;
            printError(errorMessage);
            return;
        }

        do1.generateCode();
        codeGen.generateEvalBooleanExpression(whileRegister.getExitLabel());
    }

    @Override
    public void endWhile() {
        WhileRegister whileRegister = (WhileRegister) stack.findRegister(WhileRegister.class); 

        codeGen.generateLabelJump(whileRegister.getStartLabel());
        codeGen.generateLabel(whileRegister.getExitLabel());
        
        stack.pop();
    }

    @Override
    public void saveIf(int pLine, int pCol) {
       SemanticRegister ifRegister = new IfRegister(globalHelperIfLabelCounter,pLine,pCol);
       stack.push(ifRegister);
       globalHelperIfLabelCounter++;
    }

    @Override
    public void testIf() {
        DataObject do1 = (DataObject) stack.pop();
        IfRegister ifRegister = (IfRegister) stack.findRegister(IfRegister.class); 
        
        // TODO: Enum de tipos o revisar 
        if(!(do1.getType() == "Int")){
            String errorMessage = "Expression in if statement at line: " + ifRegister.getLine() + " column: " + ifRegister.getColumn() + "is not of type int" ;
            printError(errorMessage);
            return;
        }
        do1.generateCode();
        codeGen.generateEvalBooleanExpression(ifRegister.getElseLabel());
        
    }

    @Override
    public void saveElse() {
        IfRegister ifRegister = (IfRegister) stack.findRegister(IfRegister.class); 
        codeGen.generateLabelJump(ifRegister.getExitLabel());
        codeGen.generateLabel(ifRegister.getElseLabel());
        
    }

    @Override
    public void endIf() {
        IfRegister ifRegister = (IfRegister) stack.findRegister(IfRegister.class); 
        codeGen.generateLabel(ifRegister.getExitLabel());

        // TODO: En algunos casos no 
        stack.pop(); 
    }
}
