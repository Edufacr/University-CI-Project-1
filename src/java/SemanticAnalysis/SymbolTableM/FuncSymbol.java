package SemanticAnalysis.SymbolTableM;

import java.util.ArrayList;

public class FuncSymbol extends Symbol {

    private ArrayList<VarSymbol> parameters;
    private String type;

    public FuncSymbol(String pName,String pType) {
        super(pName);
        type = pType;
        parameters = new ArrayList<VarSymbol>();
    }

    public FuncSymbol(String pName, String pType, ArrayList<VarSymbol> pParams) {
        super(pName);
        type = pType;
        parameters = pParams;
    }

    public boolean addParameter(VarSymbol pSymbol) {
        return this.parameters.add(pSymbol);
    }

    public String getType(){
        return this.type;
    }
    
    public ArrayList<VarSymbol> getParameters(){
        return this.parameters;
    }


   @Override
   public String toString() {
       return "func: " + this.getName() + ", args: " + this.parameters.toString();
   } 
}