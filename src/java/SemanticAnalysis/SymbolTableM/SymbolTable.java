package SemanticAnalysis.SymbolTableM;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SymbolTable {
    
    private HashMap<String,Symbol> table;

    public SymbolTable(){
        table = new HashMap<String,Symbol>();
    }

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

    public void print(){

        Set<Map.Entry<String,Symbol>> entries = this.table.entrySet();
        
        System.out.println("Symbol Table: ");
        System.out.println("**************");
        for(Map.Entry<String,Symbol> entry : entries ) {
            System.out.println( "Symbol: " + entry.getKey() + "\t[ " + entry.getValue().toString() + " ]" );
        }
        System.out.println("**************");
    }

    public Symbol getSymbol(String pIdentifier) {
        return table.get(pIdentifier);
    }
}



