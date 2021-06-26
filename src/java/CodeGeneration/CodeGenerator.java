package CodeGeneration;

public class CodeGenerator {
    
    private String dataSegment;
    private String codeSegment;
	private FileGenerator fileGenerator;

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


}