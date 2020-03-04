package src;

import java.util.ArrayList;

public class Family extends PassengerTypes {
	ArrayList<Person> list;
	public Family(String PType, int score) {
		super(PType, score);
		this.list = new ArrayList<Person>();
		
	}
	public void addPerson(Person p) {
		this.list.add(p);
		super.score += p.score;
	}
	public void setScore() {
		if(super.PType.charAt(0) == 'f') {
			super.score += 10;
		}
		if(super.PType.charAt(0) == 'g') {
			super.score += 5;
		}
		
	}
}
