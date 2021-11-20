package edu.kosmo.ex.scissor_rock_paper;

public class ScissorRockPaper {
	private String personSelect, computerSelect;

	public ScissorRockPaper(String mySelect) {
		super();
		this.personSelect = mySelect;
	}

	public String getMySelect() {
		return personSelect;
	}

	public String getWinner() {
		boolean tie = false;
		String winner = "tie";
		
		int gen = (int)(Math.random()*3 + 1);
		if(gen == 1)
			setComputerSelect("가위");
		else if(gen == 2)
			setComputerSelect("바위");
		else 
			setComputerSelect("보");
		System.out.println("gen: " + gen);
		System.out.println("personSelect: " + personSelect);
		System.out.println("computerSelect: " + computerSelect);
		if(personSelect.equals(computerSelect)){
			tie = true;
		}else if(personSelect.equals("가위") && computerSelect.equals("바위")){
			winner = "computer";
		}else if(personSelect.equals("가위") && computerSelect.equals("보")){
			winner = "person";
		}else if(personSelect.equals("바위") && computerSelect.equals("가위")){
			winner = "person";
		}else if(personSelect.equals("바위") && computerSelect.equals("보")){
			winner = "computer";
		}else if(personSelect.equals("보") && computerSelect.equals("가위")){
			winner = "computer";
		}else if(personSelect.equals("보") && computerSelect.equals("바위")){
			winner = "person";
		}
		System.out.println("winner: " + winner);
		return winner;
	}
	
	public void setMySelect(String personSelect) {
		this.personSelect = personSelect;
	}

	public String getComputerSelect() {
		return computerSelect;
	}

	public void setComputerSelect(String computerSelect) {
		this.computerSelect = computerSelect;
	}
	
}
