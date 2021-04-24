import java.util.ArrayList;
public class Token {

    private String token;
    private String type;
    private ArrayList<Integer> lines;

    public Token(String pToken, String pType, int pLine) {
        this.token = pToken;
        this.type = pType;
        this.lines = new ArrayList<>();
        this.lines.add(pLine);
    }

    public void addLine(int pLine) {
        this.lines.add(pLine);
    }

    public String getType() {
        return this.type;
    }

    public ArrayList<Integer>  getLines() {
        return this.lines;
    }
}