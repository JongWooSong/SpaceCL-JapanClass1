package chapter16;

public class CounterThread extends Thread {

	private Counter mCounter = null;
	
	public CounterThread(Counter counter) {
		this.mCounter = counter;
	}
	
	@Override
	public void run() {
		//쓰레드 구현부
		for(int i=0; i<10; i++) {
			mCounter.add(i);
		}
	}
	
}
