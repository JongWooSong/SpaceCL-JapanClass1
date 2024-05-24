]package chapter7.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));
        
        Collections.sort(people, new PersonComparator());
        
        System.out.println("Sorted List: ");
        for(int i=0; i<people.size(); i++) {
        	Person p = people.get(i);
        	System.out.println(  p.getName() + ", " + p.getAge() );
        }
        
	}//end method

}

class Person {

	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}//end class


class PersonComparator implements java.util.Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		System.out.print(o1.getName() + ", " + o1.getAge() + " <=====> ");
		System.out.println(o2.getName() + ", " + o2.getAge());
		
		return o1.getAge() - o2.getAge();
	}
	
}


