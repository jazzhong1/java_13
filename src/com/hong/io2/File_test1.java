package com.hong.io2;

import java.io.File;

public class File_test1 {
	public static void main(String[] args) {
		
		File file=new File("c:\\hong");
		 // c에 만들어놓은 test라는 폴더경로까지
		
		System.out.println(file.exists());//현재 디렉터리가 존재하면 true 없으면 false
		 // 현재 디렉터리가 존재하면 true 없으면 false

		System.out.println(file.isDirectory());
		// is로 시작하면 물어보는것 폴더입니까 아닙니까 물어보는것
		
		System.out.println(file.isFile());
		// 파일이냐고 물어보는것
		
		System.out.println(file.mkdir());
		// mkdir은 하나의 폴더만 만들어줌, mkdirs는 여러개의 폴더 만들어줌
		System.out.println(file.delete());
		// 해당 폴더안에 폴더가 있으면 삭제못함, 안에 있는거부터 삭제해야함
		file =new File("c:\\hong\\Test1.java");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.mkdirs());
		System.out.println(file.delete());
	
	}
}
