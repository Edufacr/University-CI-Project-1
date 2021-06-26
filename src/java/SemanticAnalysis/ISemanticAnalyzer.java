package SemanticAnalysis;

public interface ISemanticAnalyzer {

    void endOfCode();

    void completeVarDecls();
    
    void saveType(String pType, int pLine, int pCol);

    void saveIdentifier(String pIdentifier, int pLine, int pCol);

    void saveFuncCall(String pIdentifier, int pLine, int pCol);

    void saveFuncDecl();
    
    void insertVar();

    void insertFuncDecl();

    void checkVar(String pIdentifier, int pLine, int pCol);

    void checkFunc(String pIdentifier, int pLine, int pCol);

}
