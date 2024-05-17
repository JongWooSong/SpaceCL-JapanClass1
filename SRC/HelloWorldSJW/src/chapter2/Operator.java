package chapter2;

public class Operator {

	public static void main(String[] args) {
		int num = 0;
		System.out.println( --num );
		int num2 = 10;
		
		int num3 = num + num2 + num2;
		
		int num4 = (5 > 3) ? -1: 0;
		
		int num5 = 7 % 3;
		System.out.println(num5);
		
		if( 5<3 || (4<3 && 5>3) ) {
			System.out.println("실행");
			int num88 = 10;
		}
		else {
			int num88 =200;
		}
		
		int num7 = 9;
		num7 += 1;
		++num7;
		
		int num99;
		num99 = -5 + 3 * 10 /2;
		System.out.println(num99);
		
	}

}
