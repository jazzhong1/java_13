package com.hong.io2;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.filechooser.*;

public class File_make {

	private String p;
	private Calendar cal;
	private File_test5_mkdir file_test5_mkdir;
	private File_test5_mkName file_test5_mkName;
	private File file;

	public File_make() {
		p = "c:\\test";
		cal = Calendar.getInstance();
		file_test5_mkdir=new File_test5_mkdir();
		file_test5_mkName=new File_test5_mkName();
	}

	public void mkdir1() {
		System.out.print("폴더명을 입력하세요:");
		file_test5_mkdir.mkdir(p, file_test5_mkName.mkName1());
	}

	public void mkdir2() {
		System.out.println("폴더자동생성(2)");
		long carName = cal.getTimeInMillis();
		String name = String.valueOf(carName);		
		file_test5_mkdir.mkdir(p, name);
	}

	public void mkdir3() {
		System.out.println("폴더자동생성(3)");
		file_test5_mkdir.mkdir(p, file_test5_mkName.mkName3());
	}
	
	public void delete(){
		File file=new File(p);
		File[] files = file.listFiles();

		for (File f : files) {
			if (f.length() != 0) {
				f.delete();
			}
		}
	}
}
