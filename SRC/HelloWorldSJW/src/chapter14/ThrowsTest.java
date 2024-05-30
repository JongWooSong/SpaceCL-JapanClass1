package chapter14;

public class ThrowsTest {

	public static void main(String[] args) {
		
		try {
			showPrint("날 던져줘");
		} catch (Exception e) {
			System.out.println("에러는 잡아 처리 했는데");
			throw new NullPointerException();
		}
		
	}
	
	
	public static void showPrint(String str) throws Exception
	{
		System.out.println(str);
		int a = 10;
		a = a / 0;
	}

}
