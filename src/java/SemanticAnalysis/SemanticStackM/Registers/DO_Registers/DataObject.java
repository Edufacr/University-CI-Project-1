package SemanticAnalysis.SemanticStackM.Registers.DO_Registers;

import SemanticAnalysis.SemanticStackM.Registers.SemanticRegister;

public abstract class DataObject extends SemanticRegister {

    String type;
    String token;

    public String getType() {
        return this.type;
    }

    public String getToken(){
        return this.token;
    }
}
