package com.iu.io4.emp;

import java.io.*;
import java.text.*;
import java.util.*;

import com.hong.io4.member.*;

public class EmpDAO {
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private EmpDTO dto;

	public EmpDAO() {
		dto = new EmpDTO();
	}

	public void textInfo() {
		file = new File("c:\\test", "emp.txt");

		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write("사원번호" + ",");
			fw.write("id" + ',');
			fw.write("나이" + ',');
			fw.write("부서명" + ',');
			fw.write("직책" + ',');
			fw.write("월급" + ',');
			fw.write("인센티브" + ',');
			fw.write("입사일\r\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public void textInfo(EmpDTO dto) {
		file = new File("c:\\test", "emp.txt");

		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(dto.getEmpNumber()+ ",");
			fw.write(dto.getId()+ ",");
			fw.write(dto.getAge()+ ",");
			fw.write(dto.getDivision()+ ",");
			fw.write(dto.getLank()+ ",");
			fw.write(dto.getSal()+ ",");
			fw.write(dto.getInsentive()+ ",");
			fw.write(dto.getStartDay()+"\r\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public ArrayList<EmpDTO> getMember(){
		file = new File("c:\\test", "emp.txt");
		BufferedReader br=null;
		FileReader fr=null;
		ArrayList<EmpDTO> arrayList = new ArrayList<EmpDTO>();
		

		try {

			fr = new FileReader(file); // 문자하나만
			br = new BufferedReader(fr);
			while (br.ready()) { // 버퍼에 담겨있으면 true 없으면 false

				String str = br.readLine();
				// 리턴안해주면 바뀌지않음 중오**
				// trim()으로 앞뒤 공백제거

				StringTokenizer st = new StringTokenizer(str, ",");
				
				while(st.hasMoreTokens()){
					dto=new EmpDTO();
					
					dto.setEmpNumber(st.nextToken());
					dto.setId(st.nextToken());
					dto.setAge(Integer.parseInt(st.nextToken()));
					dto.setDivision(st.nextToken());
					dto.setLank(st.nextToken());
					dto.setSal(Integer.parseInt(st.nextToken()));
					dto.setInsentive(Integer.parseInt(st.nextToken()));
					dto.setStartDay(st.nextToken());
					arrayList.add(dto);
					
				}

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
	

	public String makeEmpNum() {
		Calendar ca = Calendar.getInstance();
		Date date = ca.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
		String empn = dateFormat.format(date);
		Random random = new Random();
		int num = random.nextInt(100);
		String s = String.valueOf(num);

		if (s.length() > 1 && s.length() < 3) {
			s = "0" + s;
		} else {
			s = "00" + s;
		}
		empn = empn + s;
		return empn;
	}
	
	public String makeStday() {
		Calendar ca = Calendar.getInstance();
		Date date = ca.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년도-MM월-dd일");
		String mstd = dateFormat.format(date);
		return mstd;
		
	}

	public EmpDTO empInfo(String empn, String mstd, EmpDTO empDTO) {
		EmpDTO dto=new EmpDTO();
		dto.setEmpNumber(empn);
		dto.setId(empDTO.getId());
		dto.setAge(empDTO.getAge());
		dto.setDivision(empDTO.getDivision());
		dto.setLank(empDTO.getLank());
		dto.setSal(empDTO.getSal());
		dto.setInsentive(empDTO.getInsentive());
		dto.setStartDay(mstd);
		
		return dto;
	}
	
	public EmpDTO search(String id){
		
		ArrayList<EmpDTO> arrayList = this.getMember();
		for (int i = 0; i < arrayList.size(); i++) {
			EmpDTO dto=new EmpDTO();
			if(arrayList.get(i).getId().equals(id)){
				dto=arrayList.get(i);
			}
		}
		
		
		return dto;
	}
}
