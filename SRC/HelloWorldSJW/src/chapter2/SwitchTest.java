package chapter2;

public class SwitchTest {

	public static void main(String[] args) {
		
		int age = 1;
		String str = "한글";
		
		switch(age) {
			case 10:
				System.out.println("10");
			case 1:
				System.out.println("1");
			case 5:
				System.out.println("5");
			default:
				System.out.println("age:" + age);
		}
		
		switch(str) {
			case "대한민국":
				System.out.println("대한민국");
			case "한국":
				System.out.println("한국");
			case "한글":
				System.out.println("한글");
		}
		
		//문자열 비교는 이렇게 하는 방법은 좋지않다. 왜?? 나중에 알려
//		if( str == "한글" ) {
//			System.out.println("if한글");
//		}
		
		if( "한글".equals(str) ) {
			System.out.println("if2222 - 한글");
		}
		
		
		

	}

}
