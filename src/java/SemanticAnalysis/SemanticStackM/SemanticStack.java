package SemanticAnalysis.SemanticStackM;

import java.util.Stack;
import java.util.Iterator;
import SemanticAnalysis.SemanticStackM.Registers.SemanticRegister;

public class SemanticStack {
    
    Stack<SemanticRegister> stack;

    public SemanticStack(){
        stack = new Stack<SemanticRegister>();
    }

	public SemanticRegister findRegister(Class<?> type){
		Iterator<SemanticRegister> iter = stack.iterator();
		
		while ( iter.hasNext() ) {
            SemanticRegister semanticRegister = iter.next();
			if ( type.isInstance(semanticRegister) ){
				return (SemanticRegister) semanticRegister;
			}
		}
		return null;
	}

	public SemanticRegister pop() {
		return this.stack.pop();
	}
    
    public SemanticRegister push(SemanticRegister pRegister) {
        return this.stack.push(pRegister);
    }

	public SemanticRegister peek() {
		return this.stack.peek();
	}

	@Override
	public String toString() {
		Iterator<SemanticRegister> iter = stack.iterator();
		String result = "[";

		while ( iter.hasNext() ) {
			SemanticRegister semanticRegister = iter.next();
			result += semanticRegister.toString() + ", ";
		}

        return result + "]";
	}
}
