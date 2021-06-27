package SemanticAnalysis.SemanticStackM.Registers.DO_Registers;

import SemanticAnalysis.SemanticStackM.Registers.SemanticRegister;

public abstract class DataObject extends SemanticRegister implements GenerateCode {

    String type;
    String token;

    public String getType() {
        return this.type;
    }

    public String getToken(){
        return this.token;
    }

    @Override
	public String toString() {
		return "Data Object [ type: " + this.type + ", token: "+this.token+" ]";
	}

}

