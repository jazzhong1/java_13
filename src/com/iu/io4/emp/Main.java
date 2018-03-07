package com.iu.io4.emp;

import java.lang.reflect.*;
import java.util.*;

import com.iu.io4.emp.view.*;

public class Main {

public static void main(String[] args) {
	EmpDTO dto=new EmpDTO();
	EmpDAO dao=new EmpDAO();

	//사원추가
	EmpDTO dto2;
	dto2=dao.makeinfo();
	dto.setEmpNumber(dto2.getEmpNumber());
	dto.setStartDay(dto2.getStartDay());
	dto.setAge(22);
	dto.setDivision("개발부서");
	dto.setId("jazzhong");
	dto.setInsentive(30);
	dto.setLank("대리");
	dto.setSal(200);
	dto=dao.join(dto);
	dao.textInfo(dto);
	
	//전체사원정보
	ArrayList<EmpDTO> arrayList=dao.getMember();
	EmpView empView=new EmpView();
	empView.view(arrayList);
	
	//사원검색
	dto=dao.search("jazzhong");
	if(dto!=null){
		empView.view("찾기 성공");
	}
	else{
		empView.view("찾기실패");
	}
	empView.view(dto);
	
	//사원삭제
	
	}
}
