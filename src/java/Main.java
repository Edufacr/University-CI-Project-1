import java.io.FileNotFoundException;
import java.io.FileReader;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        String debugger;
        try {
        //fileName = System.console().readLine();
        //debugger = System.console().readLine();
        debugger = "";
        fileName = "test/test.c";

        FileReader file = new FileReader(fileName);
        Scanner scanner = new Scanner(file);
        Parser p = new Parser(scanner);

            if(debugger != ""){
                System.out.println("-----------------------------");
                System.out.println("Initializing Debug Session: ");
                System.out.println("-----------------------------");
                p.debug_parse();
            }
            else{
                System.out.println("-------------");
                System.out.println("Inicia Parseo");
                System.out.println("-------------");
    
                p.parse();
    
                System.out.println();
                System.out.println("-------------");
                System.out.println("Finaliza Parseo");
                System.out.println("-------------");

            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
