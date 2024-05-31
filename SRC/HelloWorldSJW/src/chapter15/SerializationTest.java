package chapter15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Person implements Serializable {

	private static final long serialVersionUID = -3740687267114611336L;
	transient String name;
	String job;

	public Person() {
	}// end constructor

	public Person(String name, String job) {
		this.name = name;
		this.job = job;
	}// end constructor

	public String toString() {
		return name + "," + job;
	}// end method

}// end class

public class SerializationTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Person personAhn = new Person("안재용", "대표이사");
		Person personKim = new Person("김철", "상무이사");
		Person personKim2 = new Person("김철22", "상무이사22");
		
		ArrayList<Person> pList = new ArrayList<>();
		pList.add(personAhn);
		pList.add(personKim);
		pList.add(personKim2);

		try {
			FileOutputStream fos = new FileOutputStream("serial.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// personAhn, personKim 값을 파일에씀 (직렬화)
			oos.writeObject(pList);
			
		} // end try

		catch (IOException e) {
			e.printStackTrace();
		} // end catch

		try {
			FileInputStream fis = new FileInputStream("serial.out");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// personAhn, personKim 값을 파일에서 읽어들임(역직렬화)
			ArrayList<Person> readList = (ArrayList<Person>) ois.readObject();
			
			for(int i=0; i<readList.size(); i++) {
				System.out.println( readList.get(i) );
			}

		} // end try

		catch (IOException e) {
			e.printStackTrace();
		} // catch

	}// end main

}// end class
