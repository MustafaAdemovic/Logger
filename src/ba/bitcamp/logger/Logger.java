package ba.bitcamp.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * This class have for a task to created a log and save in a file all from this
 * log
 * 
 * @warning you must have a logs folder, if you not have logs folder this will not work
 * @author mustafaademovic
 *
 */
public class Logger {

	private static HashMap<String, FileOutputStream> logs = new HashMap<String, FileOutputStream>();

	/**
	 * Constructor who initialization a HashMap
	 * 
	 * @param logType HashMap - Key(logType), Value(fileName)
	 * @throws FileNotFoundException
	 */
	public Logger(HashMap<String, String> logType) throws FileNotFoundException {

		String basePath = "." + File.separator + "logs" + File.separator;

		Set<String> k = logType.keySet();

		Iterator<String> it = k.iterator();

		while (it.hasNext()) {

			String key = it.next();

			String value = logType.get(key);

			File f = new File(basePath + value + ".txt");

			FileOutputStream fos = new FileOutputStream(f, true);

			logs.put(key, fos);
		}
	}

	/**
	 * This method have for a task to get a message and on her put a date and
	 * send back
	 * 
	 * @warning - if type is not initialization log is not save
	 * @param type - Type of log
	 * @param message - It is message that we will to send
	 */
	public static void log(String type, String message) {

		if (!logs.containsKey(type)) {
			return;
		}

		Date d = new Date();

		message = d.toString() + " " + message + "\n";

		FileOutputStream fos = logs.get(type);

		try {

			fos.write(message.getBytes());

			fos.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
