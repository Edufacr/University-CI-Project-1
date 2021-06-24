package SemanticAnalysis;

public interface ISemanticAnalyzer {

    void endOfCode();

    void completeVarDecls();
    
    void saveType(String pType, int pLine, int pCol);

    void saveIdentifier(String pIdentifier, int pLine, int pCol);
    
    void insertVar();
}
