package chapter4;

public class ForExam1 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		
		System.out.println("1부터 10까지의 합: " + sum);

		
		int guguNum = 2; //2단
		for(int i=1; i<10; i++) {
			int guguRes = guguNum * i;
			System.out.println( guguNum + " * " + i + " = " + guguRes );
		}
		
		//구구단 찍기 - 중첩 for 문
		for(int dan=2; dan<=9; dan++) {
			
			for(int times=1; times <= 9; times++) {
				int guguRes = dan * times;
				System.out.println( dan + "X" + times + "=" + (guguRes) );
				break;
			}
			
			System.out.println("======");
			
		}//end for
		
		
		
	}

}
