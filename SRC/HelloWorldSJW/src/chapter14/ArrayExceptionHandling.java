package chapter14;

public class ArrayExceptionHandling {

	public static void main(String[] args) {
		
		int [] arr = new int[5];
		
		try {
			int a = 19;
			a = a / 0;
			for(int i=0; i<=5; i++) {
				arr[i] = i;
				System.out.println( arr[i] );
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
			if(e instanceof ArithmeticException) {
				System.out.println("알리스매틱 익센셥");
			}
			else {
				System.out.println("익셉션 발생!!");
			}
		}
		
	}
	
}
