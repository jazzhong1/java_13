package com.hong.io3;

import java.io.*;

public class FileWriter_1 {

	public static void main(String[] args) {
		// 1. 어디에 저장할꺼냐
		File file = new File("c:\\test", "t1.text");

		FileWriter fw = null;
		try {
			fw = new FileWriter(file);	//뒤에 boolean 이 올경우 이어서 쓴다.
											//만약에 파일이 없음ㄴ 새파일을 만들고
											//있으면 삭제하고 해당파일에 추가하여라 
			//true 는 add의 역할
			//false 는 set의 덮어쓴는역활
			//default 는 false와 같다
			// 파일이 없으면
			fw.write("123\n\r"); // 알아서 바꿔준다 //t1.text에 글자를 쓴다.
								// \r 커서를 맨앞으로 땡겨주는것
								// \r\n 같이쓴다.
			fw.write("456"); // 글자가 바로옆으로 추가된다.
			fw.flush(); // Buffer이 다 차지 않아도 밀어내라
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
