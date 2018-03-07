package com.hong.io3;

import java.io.*;

public class FileReader_1 {

	public static void main(String[] args) {
		
		File file=new File("c:\\test","hong"+".txt");
		FileReader fr=null;	//지정된 파일이름을 가진 파일에대한 입력스트림생성
		BufferedReader br=null;	//문자열로 바꿔서 읽어야하기때문에 Buffer사용
		try {
			fr=new FileReader(file);	//
			br=new BufferedReader(fr);
			
			while(br.ready()){	//읽을 문자가 없을때까지
				String str=br.readLine();
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
