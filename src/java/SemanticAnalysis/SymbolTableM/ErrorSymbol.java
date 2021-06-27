package SemanticAnalysis.SymbolTableM;

public class ErrorSymbol extends Symbol{
    
    public ErrorSymbol(String pName){
        super(pName);
    }

    @Override
    public String toString() {
        return "name: " + this.getName();
    }
}
