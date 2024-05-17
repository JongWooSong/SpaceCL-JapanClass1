package chapter5;

public class Person {

	int age;
	String name;
	int height;
	int weight;
	int sight;//시력
	int address;//주소
	
	//생성자
	public Person() {
		this(20, "ㅁㅁㅁ", 100, 200);
		System.out.println("나는 생성자이다.");
	}
	
	public Person(int age, String name) {
		this(age, name, 0, 0);
	}
	
	public Person(int age, String name, int height, int weight) {
		//this();
		this.age = age; //X: age = age (네코짱 안됨)
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public void showInfo() {
		System.out.println(age);
		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);
	}
	
	public int showInfo(int a) {
		return 0;
	}
	
	public static void main(String[] ar) {
		
		Person p1 = new Person(20, "홍길동");
		p1.showInfo();
		
		//Person p2 = new Person();
		//p2.showInfo();
		
	}
	
}
