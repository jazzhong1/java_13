package com.hong.io4.view;

import java.util.*;

import com.hong.io4.member.*;

public class MemberView {

	public void View(ArrayList<MemberDTO> arrayList) {
		for(MemberDTO dto:arrayList){
			System.out.println("=========================");
			System.out.println("id: "+dto.getId());
			System.out.println("pw: "+dto.getPw());
			System.out.println("name: "+dto.getName());
			System.out.println("phnum: "+dto.getPhnum());
		}
	}
	
	public void View(MemberDTO dto) {
			System.out.println("=========================");
			System.out.println("id: "+dto.getId());
			System.out.println("pw: "+dto.getPw());
			System.out.println("name: "+dto.getName());
			System.out.println("phnum: "+dto.getPhnum());
	}
	
	public void View(String s) {
		System.out.println(s);
	}
}
