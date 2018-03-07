package com.hong.io2;

import java.io.*;

public class File_view {
	
	public void view(File file){
			if(file.isDirectory()){
				this.view("파일생성성공");
				System.out.println(file.getPath());
			}
			else{
				this.view("파일생성실패");
			}
	}
	public void view(String str){
			System.out.println(str);
		
	}
		
}
