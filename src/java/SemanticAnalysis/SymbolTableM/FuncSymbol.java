package SemanticAnalysis.SymbolTableM;

import java.util.ArrayList;

public class FuncSymbol extends Symbol {

    private ArrayList<Symbol> parameters;

    public FuncSymbol(String pName) {
        super(pName);
        parameters = new ArrayList<Symbol>();
    }

    public boolean addParameter(Symbol pSymbol) {
        return this.parameters.add(pSymbol);
    }

   @Override
   public String toString() {
       return "func: " + this.getName() + ", args: " + this.parameters.toString();
   } 
}