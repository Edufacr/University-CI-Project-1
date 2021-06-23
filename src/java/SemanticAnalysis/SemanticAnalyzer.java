package SemanticAnalysis;
import SemanticAnalysis.SemanticStackM.*;
import SemanticAnalysis.SemanticStackM.Registers.*;
import SemanticAnalysis.SymbolTableM.*;

public class SemanticAnalyzer implements ISemanticAnalyzer{

    SemanticStack stack;
    SymbolTable   table;

    public SemanticAnalyzer(){
        this.stack = new SemanticStack();
        this.table = new SymbolTable();
    }

    private void printError(String pMessage){
        System.out.println("Semantic Error: ");
        System.out.println(pMessage);
    }
    
    @Override
    public void saveType(String pType, int pLine, int pCol) {
        SemanticRegister register = new TypeRegister(pType,pLine,pCol);
        stack.push(register);
    }

    @Override
    public void saveIdentifier(String pIdentifier, int pLine, int pCol) {

        SemanticRegister register = new IdRegister(pIdentifier,pLine,pCol);
        stack.push(register);
        
        String printing = stack.toString();
        System.out.println(printing);
    }

    @Override
    public void insertVar() {
        TypeRegister type = (TypeRegister) stack.findRegister(TypeRegister.class);

        while(!(stack.peek() instanceof TypeRegister)){
            IdRegister identifier = (IdRegister) stack.pop();

            if(!(table.isDefined(identifier.getId()))){
                Symbol symbol = new VarSymbol(identifier.getId(), type.getType());
                table.insertSymbol(identifier.getId(), symbol);
            } else {
                printError("Identifier: " + identifier.getId() + " in line: "+ (identifier.getLine() + 1) + ", in column: " + (identifier.getColumn() + 1) + " is already defined.");
            }
        }
    }
}
