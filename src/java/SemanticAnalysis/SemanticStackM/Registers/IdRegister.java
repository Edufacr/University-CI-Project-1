package SemanticAnalysis.SemanticStackM.Registers;

public class IdRegister extends SemanticRegister {
    private final String id;
    
    public IdRegister(String pId, int pLine, int pCol){
        super(pLine, pCol);
        id = pId;
    }
    
    public String getId() {
        return id;
    }

	@Override
	public String toString() {
		return "IdRegister: " + this.id;
	}
}
