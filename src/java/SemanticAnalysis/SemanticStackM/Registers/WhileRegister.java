package SemanticAnalysis.SemanticStackM.Registers;

public class WhileRegister extends SemanticRegister{
    private String startLabel;
    private String exitLabel;


    public WhileRegister(String pStartLabel, String pExitLabel){
        this.startLabel = pStartLabel;
        this.exitLabel = pExitLabel;
    }

    public String getStartLabel() {
        return this.startLabel;
    }
    
    public String getExitLabel() {
        return this.exitLabel;
    }

    @Override
    public String toString() {
        return "[ WhileDecl: [ start: " + getStartLabel() + ", exit: " + getExitLabel() + " ] ] ";
    }
}