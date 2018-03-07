package com.iu.io4.emp;

import java.lang.reflect.*;
import java.util.*;

import com.iu.io4.emp.view.*;

public class Main {

public static void main(String[] args) {
	EmpDTO dto=new EmpDTO();
	EmpDAO dao=new EmpDAO();
	dao.textInfo();
	dao.makeEmpNum();
	dao.makeStday();
	
	dto.setAge(22);
	dto.setDivision("개발부서");
	dto.setId("jazzhong");
	dto.setInsentive(3000000);
	dto.setLank("대리");
	dto.setSal(2000000);
	
	dao.makeStday();
	dao.makeEmpNum();
	dto=dao.empInfo(dao.makeEmpNum(), dao.makeStday(), dto);
	dao.textInfo(dto);
	
	ArrayList<EmpDTO> arrayList=dao.getMember();
	
	EmpView empView=new EmpView();
	empView.View(arrayList);
	
	dto=dao.search("jazzhong");
	empView.View(dto);
	
	}
}
