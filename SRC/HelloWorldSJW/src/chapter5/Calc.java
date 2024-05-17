package chapter5;

public class Calc {

	int a, b;
	int c, d;
	int abc;
	
	public void add(int a, int b) {
		System.out.println( a + " + " + b + " = " + (a + b) );
	}
	
	public void minus(int a, int b) {
		System.out.println( a + " - " + b + " = " + (a - b) );
	}
	
	public void multiple(int a, int b) {
		System.out.println( a + " * " + b + " = " + (a * b) );
	}
	
	public void devide(int a, int b) {
		System.out.println( a + " / " + b + " = " + (a / b) );
	}
	
	public static void main(String[] args) {
	
		Calc cal1 = new Calc();
		
		//add 함수를 호출 했을때 a, b 인수값을 더한값을 출력
		cal1.add(10, 20);  
		
		//minus 함수를 호출 했을때 a, b 인수값을 더한값을 출력
		cal1.minus(10, 20);
		
		//multiple 함수를 호출 했을때 a, b 인수값을 더한값을 출력
		cal1.multiple(10, 20);
		
		//devide 함수를 호출 했을때 a, b 인수값을 더한값을 출력
		cal1.devide(10, 20);
	}

}
