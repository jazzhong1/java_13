package com.hong.io4.member;
import java.util.*;

import com.hong.io4.view.*;

public class MemberController {
	private Scanner sc ;
	private MemberDTO memberDTO;
	private MemberDAO memberDAO;
	private Memberinput memberinput;
	private MemberView memberView;
	

	public MemberController() {
		sc=new Scanner(System.in);
		memberDTO=new MemberDTO();
		memberDAO=new MemberDAO();
		memberinput=new Memberinput();
		memberView=new MemberView();
	}

	public void start() {

		boolean check = true;
		while (check) {
			System.out.println("1.회원가입|2.로그인|3.삭제|4.회원정보출력|아무키.종료");
			int select=sc.nextInt();

			switch (select) {
			case 1:
				memberDTO=memberinput.join();
				memberDAO.join(memberDTO);
				break;

			case 2:
				memberDTO=memberinput.login();
				MemberDTO dto=memberDAO.login(memberDTO);
				if(dto!=null){
					memberView.View("로그인성공");
				}
				else{
					memberView.View("로그인실패");
				}
				break;

			case 3:
				String id=memberinput.delete();
				boolean c=memberDAO.delete(id);
				if(c){
					memberView.View("삭제성공");
				}
					System.out.println("삭제실패");
				
				break;

			case 4:
				memberView.View(memberDAO.getMembers());
				break;

			default:
				check = !check;
				break;
			}

		}
	}
}
