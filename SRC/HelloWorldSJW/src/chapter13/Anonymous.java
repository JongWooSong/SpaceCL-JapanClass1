package chapter13;

public class Anonymous {

	//멤버변수
	private Anonymous an = new Anonymous();
	
	private Runnable ru = new Runnable() {
		@Override
		public void run() {
			
		}
	};
	
	
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("rurnrurjhrururn");
			}
		};
		
		runnable.run();
		
	}
	
}
