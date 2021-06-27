package SemanticAnalysis.SemanticStackM.Registers;

public class FuncCallRegister extends SemanticRegister{

    private String id;
    
    public FuncCallRegister(String pId, int pLine, int pCol){
        super(pLine, pCol);
        id = pId;
    }
    
    public String getId() {
        return id;
    }

	@Override
	public String toString() {
		return "FuncCallRegister: " + this.id;
	}
}
