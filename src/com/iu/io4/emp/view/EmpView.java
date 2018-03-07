package com.iu.io4.emp.view;

import java.util.*;

import com.iu.io4.emp.*;

public class EmpView {
	
	public void View(ArrayList<EmpDTO>arrayList){
		for(EmpDTO dto:arrayList){
			System.out.println("사원번호: "+dto.getEmpNumber());
			System.out.println("Id: "+dto.getId());
			System.out.println("부서명: "+dto.getDivision());
			System.out.println("직책: "+dto.getLank());
			System.out.println("월급: "+dto.getInsentive());
			System.out.println("인센티브: "+dto.getInsentive());
			System.out.println("입사날짜: "+dto.getStartDay());
		}
		
	}
	
	public void View(EmpDTO dto){
			System.out.println("사원번호: "+dto.getEmpNumber());
			System.out.println("Id: "+dto.getId());
			System.out.println("부서명: "+dto.getDivision());
			System.out.println("직책: "+dto.getLank());
			System.out.println("월급: "+dto.getInsentive());
			System.out.println("인센티브: "+dto.getInsentive());
			System.out.println("입사날짜: "+dto.getStartDay());
		
	}


			
		
}
