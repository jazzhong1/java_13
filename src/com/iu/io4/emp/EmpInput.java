package com.iu.io4.emp;

import java.util.Scanner;

public class EmpInput {
	private Scanner sc;
	private EmpDTO dto;
	
	public EmpInput() {
		sc=new Scanner(System.in);
	}
	
	public EmpDTO join(EmpDTO dtoin){
		
		dto=new EmpDTO();
		
		System.out.println("사원번호:"+dtoin.getEmpNumber());
		dto.setEmpNumber(dtoin.getEmpNumber());
		System.out.println("아이디:");
		dto.setId(sc.next());
		System.out.println("나이:");
		dto.setAge(sc.nextInt());
		System.out.println("부서:");
		dto.setDivision(sc.next());
		System.out.println("직책:");
		dto.setLank(sc.next());
		System.out.println("월급:");
		dto.setSal(sc.nextInt());
		System.out.println("인센티브:");
		dto.setInsentive(sc.nextInt());
		dto.setStartDay(dtoin.getStartDay());
		return dto;
	}
	
public String search(){
		System.out.println("id입력:");
		String id=sc.next();
		return id;
	}

public String delete(){
	System.out.println("id입력:");
	String id=sc.next();
	return id;
}

public String check(){
	System.out.println("id입력:");
	String id=sc.next();
	return id;
}
	

}
