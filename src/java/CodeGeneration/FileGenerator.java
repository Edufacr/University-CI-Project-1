package CodeGeneration;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileGenerator implements IConstants {

	private String content;

	public FileGenerator(){
		loadTemplate(); 
	}

	private boolean loadTemplate() {
        try {
            content = new String (Files.readAllBytes(Paths.get(TEMPLATE_PATH)));
			return true;
        } catch(Exception ignored){}
        
		return false;
	}
	
	public void addDataSegment(String pDataSeg) {
		content = content.replace(DATA_SEGMENT, pDataSeg);
	}

	public void addCodeSegment(String pCodeSeg) {
		content = content.replace(CODE_SEGMENT, pCodeSeg);
	}
	
	public boolean saveCode() {
		try {
			File output = new File(OUTPUT_PATH + "Test" + ".asm");
			output.createNewFile();
			// TODO: Dynamically get filename from user input file
            FileWriter myWriter = new FileWriter(OUTPUT_PATH + "Test" + ".asm");
            myWriter.write(content);
            myWriter.close();
			System.out.println("Succes Creating File at: " + OUTPUT_PATH);
			return true;
		} catch(Exception e){
			System.out.println(e.getMessage());
		}

		return false;
	}

	public void cleanTemplate() {
		loadTemplate();
	}
}
