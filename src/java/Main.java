import java.io.FileNotFoundException;
import java.io.FileReader;

import SemanticAnalysis.SemanticAnalyzer;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        String fileName;
        String testRoute;
        String extension;
        String debugger;

        try {
            //fileName = System.console().readLine();
            //debugger = System.console().readLine();
            debugger = "";
            testRoute = "test/";
            fileName = "Errores";
            extension = ".c";

            SemanticAnalyzer sm = SemanticAnalyzer.getInstance();
            sm.setFileName(fileName);

            FileReader file = new FileReader(testRoute + fileName + extension);
            Scanner scanner = new Scanner(file);
            Parser p = new Parser(scanner);

                if(debugger != "") {
                    System.out.println("-----------------------------");
                    System.out.println("Initializing Debug Session: ");
                    System.out.println("-----------------------------");
                    p.debug_parse();
                } else {
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
            e.printStackTrace();
        }
    }
}
