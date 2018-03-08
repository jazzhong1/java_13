package com.iu.io4.emp;

import java.text.*;
import java.util.*;

public class EmpInput {
	private Scanner sc;
	private EmpDTO dto;
	
	public EmpInput() {
		sc=new Scanner(System.in);
	}
	
	
public String search(){
		System.out.println("사원번호입력:");
		String empnum=sc.next();
		return empnum;
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

public EmpDTO add() {
	// TODO 자동 생성된 메소드 스텁
	dto=new EmpDTO();
	
	System.out.println("사원번호:"+this.makeinfo().getEmpNumber());
	dto.setEmpNumber(this.makeinfo().getEmpNumber());
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
	dto.setStartDay(this.makeinfo().getStartDay());
	return dto;	
}

private EmpDTO makeinfo() {
	//EmpInput으로 빼서 해야함.
	dto = new EmpDTO();

	Calendar ca = Calendar.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
	String empn = dateFormat.format(ca.getTime());
	Random random = new Random();
	int num = random.nextInt(100)+1;
	String s = String.valueOf(num);

	if (s.length() == 1) {
		s = "00" + s;
	} else if (s.length() == 2) {
		s = "0" + s;
	}
	empn = empn + s;
	dto.setEmpNumber(empn);

	dateFormat = new SimpleDateFormat("yyyy년도-MM월-dd일");
	String mstd = dateFormat.format(ca.getTime());

	dto.setStartDay(mstd);

	return dto;
}

}
