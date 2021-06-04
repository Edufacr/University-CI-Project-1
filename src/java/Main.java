import java.io.FileNotFoundException;
import java.io.FileReader;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "test/cup.c";
        FileReader file = new FileReader(fileName);
        Scanner scanner = new Scanner(file);
        Parser p = new Parser(scanner);
        
        try {
            System.out.println("-------------");
            System.out.println("Inicia Parseo");
            System.out.println("-------------");
            System.out.println();

            p.parse();
            // if(p.parse().parse_state != 1){
            //     System.out.println("-----------------------------");
            //     System.out.println("Initializing Debug Session: ");
            //     System.out.println("-----------------------------");
            //     p.debug_parse();
            // }
            System.out.println();
            System.out.println("-------------");
            System.out.println("Finaliza Parseo");
            System.out.println("-------------");
        }
        catch (Exception e) {
            System.out.println("Caught an exception.");
        }
    }
}
