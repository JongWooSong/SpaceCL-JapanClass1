package chapter2;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //입력을 받는 코드
		System.out.println("나이를 입력 하세요");
		
		int age = sc.nextInt(); //입력받을때까지 커서가 깜빡이면서 대기하는 코드
		int charging = 1000;
		
		if( age >= 20 ) {
			charging += 1000;
		}
		
		if(  age > 40 ) {
			charging += 1000;
		}
		
		if( age >= 65 ) {
			charging -= charging * 0.2;
		}
	
		System.out.println("당신의 입장료는 " + charging + " 입니다.");
		
	}

}
