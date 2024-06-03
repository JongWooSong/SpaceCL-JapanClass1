package chapter16;

public class PtRun implements Runnable {

	private int seq;
	
	public PtRun(int seq) {
		this.seq = seq;
	}
	
	@Override
	public void run() {
		//실행부
		System.out.println( seq + " 쓰레드 - 시작" );
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println( seq + " 쓰레드 - 종료" );
	}

}
