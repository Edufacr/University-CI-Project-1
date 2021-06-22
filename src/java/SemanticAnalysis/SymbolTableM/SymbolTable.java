package SemanticAnalysis.SymbolTableM;

import java.util.HashMap;

public class SymbolTable {
    
    private HashMap<String,Symbol> table;

    public boolean isDefined(String pIdentifier){
        return table.containsKey(pIdentifier);
    }

    public boolean insertSymbol(String pIdentifier, Symbol pSymbol){

        if(isDefined(pIdentifier)){
            return false;
        }
        
        table.put(pIdentifier, pSymbol);
        return true;
    }
}



