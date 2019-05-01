package br.com.votacao_aleixo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class Util {
	public String getBase64Image(String path){
		String base64File = "";
		String base = "";
		File file = new File(path);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a file from file system
			byte fileData[] = new byte[(int) file.length()];
			imageInFile.read(fileData);
			base = Base64.getEncoder().encodeToString(fileData);
			String header = "";
	        if(file.getName().contains("png")) {
	                header = "data:image/png;base64,";
	        } else if(file.getName().contains("jpg") || file.getName().contains("jpeg")) {
	                header = "data:image/jpg;base64,";
	        }
	        base64File = header + base;
	        return base64File;
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
			return null;
		} catch (IOException ioe) {
			System.out.println("Exception while reading the file " + ioe);
			return null;
		}
	}
}
