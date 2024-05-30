package chapter13;

public class TestNumber {

	public static void main(String[] args) {
		
		MyNumber max = (x, y) -> {
			return x + y;
			};
		System.out.println( max.getMax(10, 20) );
	}
	
}
