package SemanticAnalysis.SemanticStackM.Registers.DO_Registers;

public class DO_ConstInt extends DataObject {

    private final int value;

    public DO_ConstInt(int value, String type) {
        this.value = value;
        super.type = type;
        super.token = String.valueOf(value);
    }

    @Override
    public String generateCode() {
        return "mov bx, " + value;
    }
}
