package SemanticAnalysis.SemanticStackM.Registers;

public class OperatorRegister extends SemanticRegister {
    private final String token;

    public OperatorRegister(String pId, int pLine, int pCol){
        super(pLine, pCol);
        token = pId;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "IdRegister: " + this.token;
    }
}
