package com.iu.io4.emp;

import java.io.*;
import java.lang.reflect.Array;
import java.text.*;
import java.util.*;

import com.hong.io4.member.*;
import com.iu.io4.emp.view.EmpView;

public class EmpDAO {
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private EmpDTO dto;
	private ArrayList<EmpDTO> arrayList;
	private Calendar ca;
	private SimpleDateFormat dateFormat;
	private Date date;
	private Random random;
	private StringTokenizer st;

	public EmpDAO() {
		dto = new EmpDTO();
		file = new File("c:\\test", "emp.txt");
	}

	public ArrayList<EmpDTO> getMember() {
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();

		try {

			fr = new FileReader(file); // 문자하나만
			br = new BufferedReader(fr);
			while (br.ready()) { // 버퍼에 담겨있으면 true 없으면 false

				String str = br.readLine();
				// 리턴안해주면 바뀌지않음 중오**
				// trim()으로 앞뒤 공백제거

				st = new StringTokenizer(str, ",");

				while (st.hasMoreTokens()) {
					dto = new EmpDTO();

					dto.setEmpNumber(st.nextToken());
					dto.setId(st.nextToken());
					dto.setAge(Integer.parseInt(st.nextToken()));
					dto.setDivision(st.nextToken());
					dto.setLank(st.nextToken());
					dto.setSal(Integer.parseInt(st.nextToken()));
					dto.setInsentive(Integer.parseInt(st.nextToken()));
					dto.setStartDay(st.nextToken());
					ar.add(dto);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		return ar; // Reference기본값은은 null
	}

	public EmpDTO makeinfo() {
		dto = new EmpDTO();

		ca = Calendar.getInstance();
		date = ca.getTime();
		dateFormat = new SimpleDateFormat("yyMM");
		String empn = dateFormat.format(date);
		random = new Random();
		int num = random.nextInt(100);
		String s = String.valueOf(num);

		if (s.length() == 1) {
			s = "00" + s;
		} else if (s.length() == 2) {
			s = "0" + s;
		}
		empn = empn + s;
		dto.setEmpNumber(empn);

		date = ca.getTime();
		dateFormat = new SimpleDateFormat("yyyy년도-MM월-dd일");
		String mstd = dateFormat.format(date);

		dto.setStartDay(mstd);

		return dto;
	}

	public void join(EmpDTO empDTO) {
		dto = new EmpDTO();
		dto.setEmpNumber(empDTO.getEmpNumber());
		dto.setId(empDTO.getId());
		dto.setAge(empDTO.getAge());
		dto.setDivision(empDTO.getDivision());
		dto.setLank(empDTO.getLank());
		dto.setSal(empDTO.getSal());
		dto.setInsentive(empDTO.getInsentive());
		dto.setStartDay(empDTO.getStartDay());

		fw = null;
		try {
			fw = new FileWriter(file, true);
			fw.write(dto.getEmpNumber() + ",");
			fw.write(dto.getId() + ",");
			fw.write(dto.getAge() + ",");
			fw.write(dto.getDivision() + ",");
			fw.write(dto.getLank() + ",");
			fw.write(dto.getSal() + ",");
			fw.write(dto.getInsentive() + ",");
			fw.write(dto.getStartDay() + "\r\n");
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

	public EmpDTO search(String id) {

		arrayList = this.getMember();
		EmpDTO dto = null;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getId().equals(id)) {
				dto = arrayList.get(i);
			}
		}

		return dto;
	}

	public boolean delete(String id) {
		arrayList = this.getMember();
		boolean check = false;
		for (int i = 0; i < arrayList.size(); i++) {
			dto = null;
			if (arrayList.get(i).getId().equals(id)) {
				dto = arrayList.get(i);
				arrayList.remove(dto);
				check = !check;
			}

		}

		try {
			fw = new FileWriter(file);
			for (EmpDTO dto : arrayList) {
				fw.write(dto.getEmpNumber() + ',');
				fw.write(dto.getId() + ',');
				fw.write(String.valueOf(dto.getAge()) + ',');
				fw.write(dto.getDivision() + ',');
				fw.write(dto.getLank() + ',');
				fw.write(String.valueOf(dto.getSal()) + ',');
				fw.write(String.valueOf(dto.getInsentive()) + ',');
				fw.write(dto.getStartDay() + "\r\n");
				fw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return check;

	}

	public EmpDTO check(EmpDTO cdto) {
		
		EmpView empView=new EmpView();
		EmpInput empInput=new EmpInput();
		
		arrayList = this.getMember();
		dto=null;
		
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i).getId().equals(cdto.getId())){
				empView.view("아이디가 중복됩니다.");
				cdto.setId(empInput.check());
				dto=cdto;
				i=0;
				continue;
			}
			
			if(arrayList.get(i).getEmpNumber().equals(cdto.getEmpNumber())){
				empView.view("사원번호가중복됩니다.");
				cdto.setId(this.makeinfo().getEmpNumber());
				dto=cdto;
				i=0;
				continue;
			}
			
		}
		return dto;

	}

}
