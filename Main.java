package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void readPersons(FileReader in, BufferedReader buff, DataBase a) throws NumberFormatException, IOException {
		String line = null;
		
		
		line = buff.readLine();
		int n = Integer.parseInt(line);
		//System.out.println(n);
		int cont = 0;
		
		while((line = buff.readLine()) != null) {
			//System.out.println(line);

			cont++;
			
			String[] words = line.split(" ", 0);
			
			String PType = words[0];
			String name = words[1];
			int age = Integer.parseInt(words[2]);
			char ticketType = words[3].charAt(0);
			boolean priorityE = Boolean.parseBoolean(words[4]);
			boolean specialN = Boolean.parseBoolean(words[5]);
			
			Person p = new Person(PType, name, age, ticketType, priorityE, specialN);
			p.setScore();
			
			if(a.containsO(p.PType)) {
				int index = a.getIndex(p.PType);
				PassengerTypes o = a.list.get(index);
				o.score += p.score;
			} else if(p.PType.charAt(0) == 'g') {
				PassengerTypes o = new Group(PType, p.score);
				a.list.add(o);
			}
			else if(p.PType.charAt(0) == 'f') {
				PassengerTypes o = new Family(PType, p.score);
				a.list.add(o);
			}
			else if(p.PType.charAt(0) == 's') {
				PassengerTypes o = new Single(PType, p.score);
				a.list.add(o);
			}

			if(cont == n)
				break;
		}
		
	}
	
	public static void readCommands(FileReader in, BufferedReader buff, DataBase db, MaxHeap heap) throws IOException {
		
		String line = null; int cont = 0;
		while((line = buff.readLine()) != null) {
			//System.out.println(++cont);
			String[] words = line.split(" ", 0);
			if(words[0].equals("insert")) {
				String pers = words[1];
				for(PassengerTypes p: db.list) {
					if(p.PType.equals(pers))
					{
						//System.out.println("Pers " + p.PType);
						heap.addP(p, heap.root);}
				}
			}
			if(words[0].equals("embark")) {
				heap.embark();
			}
			if(words[0].equals("list")) {
				//System.out.println("da");
				heap.displayAll(heap.root);
				System.out.println();
			}
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		String file = "queue.in";
		FileReader in = new FileReader(file);
		BufferedReader buff = new BufferedReader(in);
		
		DataBase db = new DataBase();
		readPersons(in, buff, db);
		db.setScore();
		MaxHeap heap = new MaxHeap(db.list.size());
		db.displayAll();
		readCommands(in, buff, db, heap);
		buff.close();
		
		
//		 System.out.println("root:" + heap.root.p.PType);
//		 
//		 System.out.println("left:"+ heap.root.left.p.PType);
//		 
//		 
//		  System.out.println("left left:"+ heap.root.left.left.p.PType);
//		 System.out.println("right:"+ heap.root.right.p.PType);
		 
	}
}
