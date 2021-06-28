package SemanticAnalysis.SemanticStackM.Registers;

public class WhileRegister extends SemanticRegister{
    private String startLabel;
    private String exitLabel;
    private int line;
    private int col;


    public WhileRegister(String pStartLabel, String pExitLabel, int pLine, int pCol) {
        this.startLabel = pStartLabel;
        this.exitLabel = pExitLabel;
        this.line = pLine;
        this.col = pCol;
    }

    public String getStartLabel() {
        return this.startLabel;
    }
    
    public String getExitLabel() {
        return this.exitLabel;
    }

    public int getLine() {
        return this.line;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    public String toString() {
        return "[ WhileDecl: [ start: " + getStartLabel() + ", exit: " + getExitLabel() + " ] ] ";
    }
}