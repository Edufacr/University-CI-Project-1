package SemanticAnalysis.SymbolTableM;

public class VarSymbol extends Symbol{
    private String type;

    public VarSymbol(String pName, String pType){
        super(pName);
        type = pType;
    }

    public String getType() {
        return type;
    }
}
