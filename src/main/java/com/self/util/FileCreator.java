package com.self.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCreator implements AutoCloseable{

	FileOutputStream fos;

	public FileCreator(String fileNameAndLocation) throws FileNotFoundException {
		fos = new FileOutputStream(new File(fileNameAndLocation));
	}

	public void writeFile(String lines) {
		try {
			fos.write(lines.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		try{
			fos.close();
		}catch(Exception e){
			//just close it.
		}
	}

}
