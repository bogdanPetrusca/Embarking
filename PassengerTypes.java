package src;

public abstract class PassengerTypes implements Cloneable {
	String PType;
	int score;
	char ticketType;
	boolean priorityE, specialN;
	public PassengerTypes(String name, int score) {
		this.PType = name;
		this.score = score;
	}
	public void display() {
		System.out.println(this.PType + " " + this.score);
	}
	public abstract void addPerson(Person p);
	public abstract void setScore();
}
