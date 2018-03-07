package com.hong.io2;

import java.text.*;
import java.util.*;

public class File_test5_mkName {
	private Scanner sc;
	private SimpleDateFormat dateFormat;
	private Calendar cal;
	private Date date;
	private Random random;

	public File_test5_mkName() {
		sc = new Scanner(System.in);
		cal = Calendar.getInstance();
		random = new Random();
		date = new Date();
	}
	public String mkName1(){
		String name= sc.next();
		return name;
	}
	
	public String mkName2(){
		long carName = cal.getTimeInMillis();
		String name = String.valueOf(carName);
		return name;
	}
	
	public String mkName3(){
		int num = random.nextInt(100);
		date = cal.getTime();
		dateFormat = new SimpleDateFormat("HH시-mm분-ss초" + num);	//대문자HH는 24시간기준으로
		String name = dateFormat.format(date).toString();
		return name;
	}
	

}
