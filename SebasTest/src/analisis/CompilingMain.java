package analisis;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.StringReader;



/**
 *
 * @author Luis
 */
public class CompilingMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String texto="hola";
            System.out.println("Inicia el analisis...\n");
            scanner scan = new scanner(new BufferedReader( new StringReader(texto)));
            parser parser = new parser(scan);
            parser.parse();
            System.out.println("Finaliza el analisis...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}