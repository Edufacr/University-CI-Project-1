package SemanticAnalysis.SemanticStackM.Registers;

public class IfRegister extends SemanticRegister {
    private String elseLabel;
    private String exitLabel;

    public IfRegister(int pLabelNum, int pLine, int pCol){
        super(pLine, pCol);
        elseLabel = "elseLabel" + pLabelNum;
        exitLabel = "exitLabel" + pLabelNum;
    }

    public String getElseLabel() {
        return elseLabel;
    }
    public String getExitLabel() {
        return exitLabel;
    }

    @Override
    public String toString() {
        return "[ IfDecl: [ else: " + getElseLabel() + ", exit: " + getExitLabel() + " ] ] ";
    }


}
