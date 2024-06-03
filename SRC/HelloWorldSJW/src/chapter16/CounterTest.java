package chapter16;

public class CounterTest {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);
		
		threadA.start();
		threadB.start();
		
		counter.printLong();
	}

}
