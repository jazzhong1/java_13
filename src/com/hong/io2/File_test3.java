package com.hong.io2;

import java.io.File;
import java.io.FileReader;

public class File_test3 {

	public static void main(String[] args) {
		File file = new File("c:\\test");

		String[] str = file.list();
		for (String s : str) {
			System.out.println(s);
		}
		
		int fileNum = 0;
		int dirNum = 0;
		File[] f = file.listFiles();

		for (File fi : f) {
			if (fi.isFile())
				fileNum++;
			else if (fi.isDirectory())
				dirNum++;
			System.out.println(fi.getName());

		}
		System.out.println("파일개수: " + fileNum);
		System.out.println("폴더개수: " + dirNum);
	}

}
