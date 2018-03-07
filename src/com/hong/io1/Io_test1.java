package com.hong.io1;

import java.io.IOException;
import java.io.InputStream;

public class Io_test1 {

	public static void main(String[] args) {

		System.out.print("글자를 입력하세요:");
		InputStream in = System.in;
		// 연결하면 해제도 꼭 해야함, 비트를 처리할때 많이사용, 
		//문자를 사용하기엔 불편해서 문자전용 스트림이 따로있다.


		try {
			int num = in.read();// read는 1byte만 읽는다. 
			//영어글자는 1byte만 차지 한글은 2byte를 읽어야 제대로 읽히기 
			//때문에 한글을 입력하면 반만 읽어서 이상한 글자 출력


			char ch = (char) num;
			System.out.println("입력된 글자는:" + ch);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
