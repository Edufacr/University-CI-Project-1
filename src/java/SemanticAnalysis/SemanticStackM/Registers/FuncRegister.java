package SemanticAnalysis.SemanticStackM.Registers;

public class FuncRegister extends SemanticRegister{
    private String type;
    private String name;


    public FuncRegister(String pType, String pName){
        type = pType;
        name = pName;
    }

    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[ FunDecl: " + getName() + " Return Type: " + getType() + "] ";
    }
}
