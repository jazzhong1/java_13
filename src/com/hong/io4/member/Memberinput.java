package com.hong.io4.member;

import java.util.*;

public class Memberinput {
	private Scanner sc;
	private MemberDTO dto;
	

	public Memberinput() {
		sc=new Scanner(System.in);
	}
	
	public MemberDTO login(){
		dto=new MemberDTO();
		System.out.println("아이디를 입력하세요");
		dto.setId(sc.next());
		System.out.println("pw를 입력하세요");
		dto.setPw(sc.next());
		return dto;
	}
	
	public String delete(){
		System.out.println("삭제할 아이디를 입력하세요");
		String id=sc.next();
		return id;
	}
	
	public MemberDTO join(){
		
		dto=new MemberDTO();
		System.out.print("아이디:");
		dto.setId(sc.next());
		System.out.print("비밀번호:");
		dto.setPw(sc.next());
		System.out.print("이름:");
		dto.setName(sc.next());
		System.out.print("핸드폰번호:");
		dto.setPhnum(sc.next());
		return dto;
	}
	
}
