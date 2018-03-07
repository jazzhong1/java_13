package com.hong.io2;

import java.io.*;
import java.util.*;

public class File_controller {
	private Scanner sc;
	private File_make file_make;
	private File file;
	
	
	public File_controller() {
		sc=new Scanner(System.in);
		file_make=new File_make();
	}
	
	public void start(){
		boolean check = true;
		while (check) {
			System.out.println("1.폴더명 입력|2.폴더자동생성(1)|3.폴더자동생성(2)|4.폴더삭제|5.종료");
			int selcet=sc.nextInt();
			
			switch (selcet) {
			case 1:
				file_make.mkdir1();
				break;

			case 2:
				file_make.mkdir2();
				break;

			case 3:
				file_make.mkdir3();
				break;
			
			case 4:
				file_make.delete();
				break;
				

			default:
				check=!check;
				break;
			}
			
		}
	}

}
