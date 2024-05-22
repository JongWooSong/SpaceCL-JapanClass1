package chapter6;

public class StaticTest {

	private int number;
	private static int staticNumber;
	
	private static StaticTest instance = new StaticTest();
	
	private StaticTest() {
		
	}
	
	public static StaticTest getInstance() {
		return instance;
	}
	
	public static void main(String[] aa) {
		System.out.println("static class");
		
		for(int i=0; i<aa.length; i++) {
			System.out.println( aa[i] );
		}
		
		//number = 200;
		
		StaticTest st1 = new StaticTest();
		st1.number = 200;
		
		st1.staticNumber = 600;
		StaticTest.staticNumber = 600;
		
		staticNumber = 500;
		
	}
	
	
	public int getNumber() {
		return this.number;
	}

}
