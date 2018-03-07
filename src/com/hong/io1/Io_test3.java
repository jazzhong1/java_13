package com.hong.io1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Io_test3 {
	public static void main(String[] args) {
		
		InputStream is=System.in;
		InputStreamReader ir=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(ir);//문자열로 바꿔줌
	
		try {
			while(true){
				System.out.println("문자열을 입력하세요");
				String str=br.readLine();
				
				if(str.equals("exit")){
					break;
				}
				System.out.println("입력된 문자열:"+str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
				ir.close();
				is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}// Scanner 내부에서 어떻게 돌아가는지 보여줌
