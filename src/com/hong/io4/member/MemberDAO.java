package com.hong.io4.member;

import java.io.*;
import java.util.*;

public class MemberDAO {
	// 데이터베이스파일에 접근하여 가져온다.

	private File file;
	private FileReader fr;
	private BufferedReader br;
	private MemberDTO dto;

	public MemberDAO() {
		dto = new MemberDTO();
		file = new File("c:\\test", "member.txt");
	}

	public ArrayList<MemberDTO> getMembers() {
		// 파일의 내용을 읽어와서
		// memberDTO에 맞게 내용을 파싱
		 ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();

		try {

			fr = new FileReader(file); // 문자하나만
			br = new BufferedReader(fr);
			while (br.ready()) { // 버퍼에 담겨있으면 true 없으면 false

				String str = br.readLine();
				str = str.replace('.', ',').trim();
				// 리턴안해주면 바뀌지않음 중오**
				// trim()으로 앞뒤 공백제거

				StringTokenizer st = new StringTokenizer(str, ",");
				dto = new MemberDTO();

					dto.setId(st.nextToken()); // 한줄에 4개만 있기때문에 while안써도댐
					dto.setPw(st.nextToken());
					dto.setName(st.nextToken());
					dto.setPhnum(st.nextToken());
					arrayList.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		return arrayList; // Reference기본값은은 null
	}



	public MemberDTO login(MemberDTO memberDTO) {
		// 저장되어있는 데이터랑
		// 사용자가 입력한 아이디랑 id,pw가 같은지 판별
		// 로그인 성공 데이터가 있는 MemberDTO리턴
		// 로그인 실패 데이터가 없는 MemberDTO리턴

		ArrayList<MemberDTO> arrayList = new ArrayList<>();
		arrayList=this.getMembers();
		MemberDTO reDto = null;

		for (MemberDTO m : arrayList) {
			if (m.getId().equals(memberDTO.getId()) && m.getPw().equals(memberDTO.getPw())) {
				reDto = m;
				break;
			}
		}
		return reDto;
		// 저장소에 직접접근
	}

	public boolean delete(String id) {
		// 회원탈퇴

		ArrayList<MemberDTO> ar = this.getMembers();
		MemberDTO reDto = null;
		boolean check=false;
		
		for (MemberDTO m: ar) {
			if (m.getId().equals(id)) {
				ar.remove(m);
				check=!check;
				break;
			}
		}
		
		file = new File("c:\\test", "member.txt");
		
		if(check) {
		FileWriter fw= null;
		try {
			fw=new FileWriter(file,false);
			for (MemberDTO m: ar) {
				fw.write(m.getId()+',');
				fw.write(m.getPw()+',');
				fw.write(m.getName()+',');
				fw.write(m.getPhnum()+"\r\n");
				fw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}
		return check;
	}

	public boolean join(MemberDTO memberDTO) {
		FileWriter fw = null;

		try {
			fw = new FileWriter(file, true);
			String id=memberDTO.getId();
			fw.write("\r\n" + id + ",");

			String pw = memberDTO.getPw();
			fw.write(pw + ",");

			String name = memberDTO.getName();
			fw.write(name + ",");

			String phnum = memberDTO.getPhnum();
			fw.write(phnum);
			fw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;		
	}

		

}
