package chapter16;

public class ThreadTest1 {

	public static void main(String[] args) {
		
		System.out.println("ThreadTest1 - main() 시작");
		
		for(int i=1; i<=10; i++) {
			PtThread p = new PtThread(i);
			p.start();
		}
		
		System.out.println("ThreadTest1 - main() 종료");
		
	}
	
}
