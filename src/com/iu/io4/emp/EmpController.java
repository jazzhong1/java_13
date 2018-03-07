package com.iu.io4.emp;

import java.util.*;

import com.hong.io4.member.*;

public class EmpController {
	private Scanner sc;

	public EmpController() {
		sc=new Scanner(System.in);
	}
	
	public void start() {
		
		boolean check=true;
		while (check) {
			System.out.println("1.전체사원정보|2.사원검색|3.사원추가|4.사원퇴사|아무키.종료");
			int num=sc.nextInt();
			switch (num) {
			case 1:
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			default:
				check = !check;
				break;
			}

		}
	}
}
