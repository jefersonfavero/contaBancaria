package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Files {
	File dir = new File("./src/logs/");

	public void read(String archive) {
		try {
			String pathFile = dir + "/" + archive;
			FileReader file = new FileReader(pathFile);
			BufferedReader readInFile = new BufferedReader(file);
			String message = "";
			String line;
			do {
				line = readInFile.readLine();
				if (line != null) {
					message += line + "\n";
				}
			} while (line != null);
			System.out.println(message);
			readInFile.close();
			file.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void write(String archive, String textForFile) {
		try {
			dir.mkdir();
			String message = "";
			String pathFile = dir + "/" + archive;
			FileWriter fileWriter = new FileWriter(pathFile, true);
			PrintWriter printerInFile = new PrintWriter(fileWriter);
			message += textForFile;
			printerInFile.print(message);
			printerInFile.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
