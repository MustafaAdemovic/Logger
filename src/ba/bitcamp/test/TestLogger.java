package ba.bitcamp.test;

import java.io.FileNotFoundException;
import java.util.HashMap;

import ba.bitcamp.logger.Logger;

public class TestLogger {

	public static void main(String[] args) {
		
		HashMap<String, String> test = new HashMap<String, String>();
		
		test.put("aplication", "aplication");
		test.put("error", "error");
		test.put("warning", "warning");
		
		try {
			
			new Logger(test);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		Logger.log("aplication", "something about app");
		Logger.log("error", "something about errors");
		Logger.log("warning", "warning erors");
	}

}
