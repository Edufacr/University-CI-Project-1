package SemanticAnalysis.SemanticStackM.Registers.DO_Registers;

public class DO_ConstCharString extends DataObject {

    public DO_ConstCharString(String token, String type) {
        super.token = token;
        super.type = type;
    }

    @Override
    public String generateCode() {
        return "mov bx, "+token;
    }
}
