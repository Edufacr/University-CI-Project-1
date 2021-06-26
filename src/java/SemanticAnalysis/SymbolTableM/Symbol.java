package SemanticAnalysis.SymbolTableM;

public abstract class Symbol {
    private String name;

    public Symbol(String pName){
        name = pName;
    }

    public String getName() {
        return name;
    }
}
