import java.io.FileNotFoundException;
import java.io.FileReader;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input.c";
        FileReader file = new FileReader(fileName);
        Scanner scanner = new Scanner(file);
        Parser p = new Parser(scanner);
        
        try {
            //p.parse();
            System.out.println(p.debug_parse().value);
        }
        catch (Exception e) {
            System.out.println("Caught an exception.");
        }
    }
}
