package SemanticAnalysis.SemanticStackM.Registers;

public class TypeRegister extends SemanticRegister {
    private String type;

    public TypeRegister(String pType, int pLine, int pCol){
        super(pLine, pCol);
       this.type = pType; 
    }

    public String getType() {
        return type;
    }

	@Override
	public String toString() {
		return "TypeRegister: " + this.type;
	}
}
