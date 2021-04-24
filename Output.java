import java.util.*;

public class Output {

    private Hashtable<String,Token> structure;

    public Output() {
        this.structure = new Hashtable<String, Token>();
    }

    public void addToken(String pToken, String pType, int pLine) {
        if (this.structure.containsKey(pToken)) {
            Token createdToken = this.structure.get(pToken);
            createdToken.addLine(pLine+1);
            this.structure.put(pToken, createdToken);
        } else {
            this.structure.put(pToken, new Token(pToken, pType, pLine+1));
        }
    }

    public void printResult() {
        Set<Map.Entry<String, Token>> entries = this.structure.entrySet();

        for(Map.Entry<String, Token> entry : entries ) {
            ArrayList<Integer> lines = entry.getValue().getLines();
            System.out.println( "Token: " + entry.getKey() + "\t| Tipo: " + entry.getValue().getType() + "\t\t\t| Lineas: " + countLines(lines));
        }
    }

    private String countLines(ArrayList<Integer> pLines) {
        String result = "";
        
        Collections.sort(pLines);
        
        Set<Integer> unique = new HashSet<Integer>(pLines);

        for (int key : unique) {
            int freq = Collections.frequency(pLines, key);

            if (freq > 1) {
                result += String.valueOf(key) + "(" + String.valueOf(freq) + "), ";
            } else {
                result += String.valueOf(key) + ", ";
            }
        }
        return result;
    }

}
