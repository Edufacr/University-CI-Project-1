package CodeGeneration;

import SemanticAnalysis.SemanticStackM.Registers.DO_Registers.DataObject;
import SemanticAnalysis.SemanticStackM.Registers.OperatorRegister;
import SemanticAnalysis.SymbolTableM.FuncSymbol;
import SemanticAnalysis.SymbolTableM.VarSymbol;

import java.util.ArrayList;

public class CodeGenerator {
    
    private String dataSegment;
    private String codeSegment;
	private final FileGenerator fileGenerator;
	private boolean isOnPROC;

	public CodeGenerator() {
		this.dataSegment = "";
		this.codeSegment = "";
		this.fileGenerator = new FileGenerator();
	}
	
    public void generateGlobalVarCode(String pName, String pType){
        String decl;

        // TODO: Poner bonito la cantidad de bytes que ocupa
        decl = pName + " db " + 4 + " dup (?) ";
        
		addToDataSegment(decl);
        
    }

    public void commitDataSegment() {
        this.fileGenerator.addDataSegment(this.dataSegment);
    }
    
	public void commitCodeSegment() {
        this.fileGenerator.addCodeSegment(this.codeSegment);
    }
	
	public void addWhile() {

	}

	public void generateFile() {
		this.fileGenerator.saveCode();
		this.fileGenerator.cleanTemplate();
	}

	private void addToDataSegment(String pLine) {
		this.dataSegment += pLine + "\n";
	}

	public void addToCodeSegment(String pLine) {
		if(isOnPROC){
			isOnPROC = false;
			this.codeSegment = this.codeSegment.replace("{PROC CONTENT}", pLine);
		} else {
			this.codeSegment += pLine + "\n";
		}
	}


	public String generateOperation(String resultVarName, DataObject do1, DataObject do2, OperatorRegister op) {
		String result;
		switch (op.getToken()){
			default:
			case "assign":
				result = 	"lea di, "+do2.getToken()+"\n" +
							do1.generateCode() +"\n" +
							"mov word ptr [di], bx";
				break;
		}
		return result;
	}

	public void openProc(FuncSymbol funcSymbol, ArrayList<VarSymbol> params) {
		isOnPROC = true;
		String procName = funcSymbol.getName();
		String proc =
				procName + 	" proc near\n" +
							"	push ax\n" +
							"	push bx\n" +
							"	push cx\n" +
							"	push dx\n" +
							"	{PROC CONTENT}\n" +
							"	pop dx\n" +
							"	pop cx\n" +
							"	pop bx\n" +
							"	pop ax\n" +
							"	ret\n" +
				procName + 	" endp\n";
		this.codeSegment += proc + "\n";
	}
}