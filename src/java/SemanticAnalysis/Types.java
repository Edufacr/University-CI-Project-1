package SemanticAnalysis;

public enum Types {
    
    INT("INT"),
    CHAR("CHAR"),
    STRING("STRING"),
    ERROR("ERROR");

    public final String label;

    @Override 
    public String toString() { 
        return this.label; 
    }

    private Types(String pLabel) {
        this.label = pLabel;
    }

}
