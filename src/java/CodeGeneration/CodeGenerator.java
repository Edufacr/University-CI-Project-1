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


	public String generateOperation(String resultVarName, DataObject rightDO, DataObject leftDO, OperatorRegister op) {
		String result;
		switch (op.getToken()){
			default:
			case "=":
				result = 	rightDO.generateCode() +"\n" +
							"lea di, "+leftDO.getToken()+"\n" +
							"mov word ptr [di], bx";
				break;
			case "+":
				result = 	rightDO.generateCode() + "\n" +
							"mov ax, bx\n" +
							leftDO.generateCode() + "\n" +
							"add ax, bx\n" +
							"lea di, "+resultVarName+"\n" +
							"mov word ptr[di], ax";
				break;
			case "*":
				result = 	rightDO.generateCode() + "\n" +
							"mov ax, bx\n" +
							leftDO.generateCode() + "\n" +
							"mul bx\n" +
							"lea di, "+resultVarName+"\n" +
							"mov word ptr[di], ax";
				break;
		}
		return result;
	}

	public void generateOpenProc(FuncSymbol funcSymbol, ArrayList<VarSymbol> params) {
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

	public void generateEvalBooleanExpression(String pLabel) {
		String booleanExpression = 
			"cmp bx, 0\n" + 
			"je " + pLabel + "\n";

		this.codeSegment += booleanExpression;	
	}

	public void generateLabel(String pLabel) {
		String label =
				pLabel + ":\n";

		this.codeSegment += label;
	}

	public void generateLabelJump(String pLabel) {
		String jump = 
				"JUMP " + pLabel;	

		this.codeSegment += jump + "\n";
	}
}