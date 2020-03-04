package src;

public class Person {
	String PType, name;
	int age, score;
	char ticketType;
	boolean priorityE, specialN;
	public Person() {
		
	}
	public Person(String PType, String name, int age, char ticketType, boolean priorityE, boolean specialN) {
		this.PType = PType;
		this.name = name;
		this.age = age;
		this.ticketType = ticketType;
		this.priorityE = priorityE;
		this.specialN = specialN;
	}
	public void setScore() {
		//System.out.println("age: " + this.age);
		if(age < 2)
			this.score += 20;
		if(age >= 2 && age < 5)
			this.score += 10;
		if(age > 60)
			this.score += 15;
		if(ticketType == 'b') {
			score += 35;
		}
		if(ticketType == 'p') {
			score += 20;
		}
		if(priorityE == true) {
			score += 30;
		}
		if(specialN == true) {
			score += 100;
		}
	}
}
