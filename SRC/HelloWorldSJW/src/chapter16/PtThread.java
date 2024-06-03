package chapter16;

public class PtThread extends Thread {

	private int seq;
	
	public PtThread(int seq) {
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
