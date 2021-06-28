package SemanticAnalysis.SemanticStackM.Registers.DO_Registers;

public class DO_ExpressionVar extends DataObject{


    public DO_ExpressionVar(String token, String type) {
        super.token = token;
        super.type = type;
    }

    @Override
    public String generateCode() {
        return  "lea di, "+this.token+"\n" +
                "mov bx, word ptr [di]";
    }
}
