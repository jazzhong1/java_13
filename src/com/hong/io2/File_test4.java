package com.hong.io2;

import java.io.*;
import java.util.*;

public class File_test4 {
	
	public static void main(String[] args) {
		File file=new File("c:\\test");
		String[] names=file.list();
		
		ArrayList<File> files=new ArrayList<File>();
		
		for(String result:names){
			File file2=new File(result);
			files.add(file2);
			if(file2.isFile()){
			}
			if(file2.isDirectory()){
			}
		}
		
		for (int i = 0; i < files.size(); i++) {
			System.out.println(files.get(i).getPath());
			System.out.println(files.get(i).getName());
		}
		
			
		
		
	}
}
