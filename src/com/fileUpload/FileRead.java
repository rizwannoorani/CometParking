package com.fileUpload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileRead {

	public byte[] readFile(){
	try{
		BufferedReader br = new BufferedReader(new FileReader(new File("testFile.txt")));
	   	byte[] b = new byte[1024];
	   	 b = br.readLine().getBytes();
		return b;
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
  }	
}
