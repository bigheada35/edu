package edu.kosmo.ex;

public class Student {
	private String name, kor, eng, math;

	public Student(String name, String kor, String eng, String math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}
	
	public String getTotal() {
		String sum = null;
		sum = String.valueOf(Integer.valueOf(getKor())+
				Integer.valueOf(getEng()) +
				Integer.valueOf(getMath())
				);
		return sum;
	}
	public String getGrade(String score) {
		String ret = null;
		int inum = Integer.valueOf(score);
		System.out.print("inum : " + inum + " ");
		if(inum >= 90 )
			ret = "수";
		else if(inum >= 80)
			ret = "우";
		else if(inum >= 70)
			ret = "미";
		else if(inum >= 60)
			ret = "양";
		else
			ret = "가";
		
		return ret; 
	}
	
	
}
