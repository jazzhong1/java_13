package com.iu.io4.emp.view;

import java.util.*;

import com.iu.io4.emp.*;

public class EmpView {
	
	public void view(ArrayList<EmpDTO>arrayList){
		for(EmpDTO dto:arrayList){
		
			this.view(dto);
		}
		
	}
	
	public void view(EmpDTO dto){
			System.out.println("사원번호: "+dto.getEmpNumber());
			System.out.println("Id: "+dto.getId());
			System.out.println("부서명: "+dto.getDivision());
			System.out.println("직책: "+dto.getLank());
			System.out.println("월급: "+dto.getSal()+"만원");
			System.out.println("인센티브: "+dto.getInsentive()+"만원");
			System.out.println("입사날짜: "+dto.getStartDay());
		
	}
	
	public void view(String str){
		System.out.println(str);
}


			
		
}
