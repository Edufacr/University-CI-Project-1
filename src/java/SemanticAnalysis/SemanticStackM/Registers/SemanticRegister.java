package SemanticAnalysis.SemanticStackM.Registers;

public class SemanticRegister {
    
    private int line;
    private int column;

    public SemanticRegister(){

    }

    public SemanticRegister(int pLine, int pCol){
        line = pLine;
        column = pCol;
    }
    
    public int getColumn() {
        return column;
    }
    public int getLine() {
        return line;
    }
}
