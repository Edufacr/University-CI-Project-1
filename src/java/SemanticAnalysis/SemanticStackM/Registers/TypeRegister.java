package SemanticAnalysis.SemanticStackM.Registers;

import SemanticAnalysis.Types;

public class TypeRegister extends SemanticRegister {

    private Types type;

    public TypeRegister(Types pType, int pLine, int pCol){
        super(pLine, pCol);
        this.type = pType; 
    }

    public Types getType() {
        return type;
    }

	@Override
	public String toString() {
		return "TypeRegister: " + this.type;
	}
}
