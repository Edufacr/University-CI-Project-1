package SemanticAnalysis;

public interface ISemanticAnalyzer {

    void endOfCode();

    void completeVarDecls();
    
    void saveType(String pType, int pLine, int pCol);

    void saveIdentifier(String pIdentifier, int pLine, int pCol);

    void saveFuncCall(String pIdentifier, int pLine, int pCol);

    void saveIf(int pLine, int pCol);
    
    void testIf();

    void saveElse();

    void endIf();
    
    void saveWhile(int pLine, int pCol);
    
    void testWhile();

    void endWhile();
    
    void saveFuncDecl();
    
    void insertVar();

    void insertFuncDecl();

    void checkVar(String pIdentifier, int pLine, int pCol);

    void checkFunc(String pIdentifier, int pLine, int pCol);

    void checkInLoop(String pIdentifier, int pLine, int pCol);

    void addConstInt(String constVal);

    void addConstCharString(String charStringConst);

    void addExpressionVar(String var, int pLine, int pCol);

    void addOperator(String operator, int pLine, int pCol);

    void evalBinary(int pLine, int pCol);

}
