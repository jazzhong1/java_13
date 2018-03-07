package com.iu.io4.emp;

import java.util.*;

import com.hong.io4.member.*;
import com.iu.io4.emp.view.EmpView;

public class EmpController {
	private Scanner sc;
	private EmpDTO dto;
	private EmpDAO dao;
	private EmpInput empInput;
	private EmpView empView;
	private ArrayList<EmpDTO> arrayList;


	public EmpController() {
		sc=new Scanner(System.in);
		dto=new EmpDTO();
		dao=new EmpDAO();
		empInput=new EmpInput();
		empView=new EmpView();
	}
	
	public void start() {
		
		boolean check=true;
		while (check) {
			System.out.println("1.전체사원정보|2.사원검색|3.사원추가|4.사원퇴사|아무키.종료");
			int num=sc.nextInt();
			switch (num) {
			case 1:
				arrayList=dao.getMember();
				empView.view(arrayList);
				break;

			case 2:
				dto=dao.search(empInput.search());
				if(dto!=null){
					empView.view("찾기 성공");
				}
				else{
					empView.view("찾기실패");
				}
				dto=null;
				break;

			case 3:
				EmpDTO dto2;
				dto2=dao.makeinfo();
				dto=empInput.join(dto2);
				dao.check(dto);
				dao.join(dto);
				dto=null;
				break;

			case 4:
				boolean c=dao.delete(empInput.delete());
				if(c){
					empView.view("삭제성공");
				}
				else{
					empView.view("삭제실패");
				}
				break;

			default:
				check = !check;
				break;
			}

		}
	}
}
