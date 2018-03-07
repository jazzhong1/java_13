package com.hong.io2;

import java.io.*;

public class File_test5_mkdir {

	private File file;
	private File_view file_view;
	
	public File_test5_mkdir() {
		file_view=new File_view();
	}
	
	public boolean mkdir(String p,String name){

		file = new File(p, name);
		boolean result=file.mkdir();
		file_view.view(file);
		
		return result;
	}
}
