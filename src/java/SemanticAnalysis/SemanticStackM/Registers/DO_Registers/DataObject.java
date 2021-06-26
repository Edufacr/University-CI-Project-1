package SemanticAnalysis.SemanticStackM.Registers.DO_Registers;

import SemanticAnalysis.SemanticStackM.Registers.SemanticRegister;

public abstract class DataObject extends SemanticRegister {
    
    String type;

	public String getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return "Data Object [ type: " + this.type + " ]";
	}
}