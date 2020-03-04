package src;

public class Single extends PassengerTypes{
	Person p;
	public Single(String PType, int score) {
		super(PType, score);
		this.p = new Person();
	}
	public void addPerson(Person p) {
		this.p = p;
		super.score = score;
	}
	public void setScore() {
		super.score += p.score;
		if(super.PType.charAt(0) == 'f') {
			super.score += 10;
		}
		if(super.PType.charAt(0) == 'g') {
			super.score += 5;
		}
		if(super.ticketType == 'b') {
			super.score += 35;
		}
		if(super.ticketType == 'p') {
			super.score += 20;
		}
	}
}
