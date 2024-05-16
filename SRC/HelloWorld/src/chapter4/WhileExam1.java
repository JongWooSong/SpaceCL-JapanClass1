package chapter4;

public class WhileExam1 {

	public static void main(String[] args) {
		
		final int LOOP_NUM = 100;
		int num = 1;
		long sum = 0;
		
		while( num <= LOOP_NUM /** 무한루프 조심! */ ) {
			sum += num;
			num++;
		}
	
		System.out.println(" 1부터 " + LOOP_NUM + "까지 합: "  + sum);

		//1부터 10까지중에 홀수합, 짝수합 을 구하라
		num = 1; //num 초기화
		int even = 0, odd = 0;
		
		
		while( num <= LOOP_NUM ) {
			//짝수값을 더한다 
			if( num % 2 == 0 ) { //2로 나눈 나머지가 0 이면 짝수 
				even += num;
				continue;
			}
			else { //홀수
				odd += num;
			}
			num++; //증가 안하면 무한루프가 됨.
		}//end while
		
		System.out.println("홀수의 합: " + odd);
		System.out.println("짝수의 합: " + even);
		
	}//end main()

}//end class
