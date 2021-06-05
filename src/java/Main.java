import java.io.FileNotFoundException;
import java.io.FileReader;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "test/cup.c";
        FileReader file = new FileReader(fileName);
        Scanner scanner = new Scanner(file);
        Parser p = new Parser(scanner);
        
        try {
            p.parse();
            System.out.println();
            System.out.println("-------------");
            System.out.println("Finaliza Parseo");
            System.out.println("-------------");

            if(args[1] != "2"){
                System.out.println("-----------------------------");
                System.out.println("Initializing Debug Session: ");
                System.out.println("-----------------------------");
                p.debug_parse();
            }
        }
        catch (Exception e) {

        }
    }
}
