package chapter16;

public class ThreadTest2 {

	public static void main(String[] args) {

		System.out.println("ThreadTest1 - main() 시작");
		
		for(int i=1; i<=10; i++) {
			PtRun run = new PtRun(i);
			new Thread(run).start(); //다르다
		}
		
		System.out.println("ThreadTest1 - main() 종료");
		
		
		PtRun run = new PtRun(100);
		Thread t = new Thread(run);
		t.start();
		t.start();
		
	}

}
