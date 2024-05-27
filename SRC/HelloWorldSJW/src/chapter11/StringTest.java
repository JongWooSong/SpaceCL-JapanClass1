package chapter11;

public class StringTest {

	public static void main(String[] args) {

//		String str1 = null;
//		String str2 = new String("abc");
//		
//		System.out.println( str1 == str2 );
//		
//		System.out.println( str1.equals(str2) );
		
		String a = "안녕";
		a = a.concat("하세요");
		
		a += " 그리고 반갑 습니다.";
		System.out.println(a);
		
		StringBuffer sb = new StringBuffer();
		sb.append("안녕");
		sb.append("하세요?\n");
		sb.append("그리고");
		sb.append("반갑 습니다.");
		System.out.println("sb값: " + sb);
		
		
		Integer number1 = Integer.valueOf("11200");
		System.out.println(number1);
		
		
	}

}
