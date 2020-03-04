package src;

import java.util.ArrayList;

public class DataBase {
	ArrayList<PassengerTypes> list;
	public DataBase() {
		this.list = new ArrayList<PassengerTypes>();
		
	}
	public boolean containsO(String PType) {
		for(PassengerTypes g: list) {
			if(g.PType.equals(PType))
				return true;
		}
		return false;
	}
	
	public void addObject(PassengerTypes o) {
		this.list.add(o);
	}
	
	public int getIndex(String PType) {
		for(PassengerTypes g: list) {
			if(g.PType.equals(PType))
				return this.list.indexOf(g);
		}
		return -1;
	}
	public void displayAll() {
		for(PassengerTypes g: list) {
			System.out.println(g.PType + " " + g.score);
		}
	}
	public void setScore() {
		for(PassengerTypes p: this.list) {
			p.setScore();
			//System.out.print("daaaaaaaaaa " + p.PType + " " + p.score + " ");
		}
		//System.out.println();
	}
}
