package com.hong.io2;

import java.io.File;

public class File_test2 {
	
	public static void main(String[] args) {
		File file=new File("c:\\hong");
		file=new File(file,"test1");
		
		System.out.println(file.getPath());
		System.out.println(file.getName());
		System.out.println(file.length());
		
		file=new File("c:\\hong","test1");
		System.out.println(file.getPath());
		
	}
}
