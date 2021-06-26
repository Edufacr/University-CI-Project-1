package SemanticAnalysis;

public interface ISemanticAnalyzer {

    void endOfCode();

    void completeVarDecls();
    
    void saveType(String pType, int pLine, int pCol);

    void saveIdentifier(String pIdentifier, int pLine, int pCol);

    void saveFooDecl();
    
    void insertVar();

    void insertFooDecl();

    void checkVar(String pIdentifier, int pLine, int pCol);

    void checkFunc(String pIdentifier, int pLine, int pCol);

    void addConstInt(int constVal);

    void addConstCharString(String charStringConst);

    void addExpressionVar(String var, int pLine, int pCol);

    void addOperator(String operator);

    void evalBinary(int pLine, int pCol);
}
