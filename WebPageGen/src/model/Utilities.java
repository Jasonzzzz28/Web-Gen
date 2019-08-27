package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Provides utility methods for the system.
 * Feel free to add your own.  We have provided one
 * that allows you to write a string to a file.
 * @author UMCP
 *
 */
public class Utilities {
	
	/**
	 * Writes the provide string to the file.  Displays
	 * a message indicating the file have been created.
	 * @param filename
	 * @param data
	 */
	public static void writeToFile(String filename, String data) {
		try {
			boolean append = false;

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, append));
			bufferedWriter.write(data);

			bufferedWriter.flush();
			bufferedWriter.close();

			System.out.println("Results can be found in file: " + filename);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
