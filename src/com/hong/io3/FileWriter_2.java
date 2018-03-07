package com.hong.io3;

import java.io.*;
import java.util.*;

public class FileWriter_2 {

	public static void main(String[] args) {

		// 입력받은 글자를 파일로 저장
		// exit를 입력받을때까지
		// 입력
		// 만약 입력된 값이 exit라면 종료

		// 저장될 파일명을 입력하세요

		// 글을 입력하세요
		// 입력
		// 입력받은 글자를 파일로 저장
		// exit를 입력받을때 까지
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명을 입력하세요");
		String name = sc.nextLine();
		File file = new File("c:\\test", name + ".txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			while (true) {
				System.out.println("글을 입력하세요");
				name = sc.nextLine();// Exit, exit
				if (name.toUpperCase().equals("EXIT")) {
					System.out.println("글쓰기 종료");
					break;
				}
				fw.write(name + "\r\n");
				fw.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 저장될 파일명을 입력하세요

		// 글을입력하세요
		// 입력
		// 만약에 입력된 값이 exit라면 종료

	}

}
