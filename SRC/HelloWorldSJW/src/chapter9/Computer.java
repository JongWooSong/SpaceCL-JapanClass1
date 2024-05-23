package chapter9;

public abstract class Computer {

	public void go() {
		
		
	}
	
	//추상 메서드
	public abstract void gogo();
	
	//일반 메서드
	public void mainGo(int type) {
		if(type == 1) {
			go();
		}
		else {
			gogo();
		}
	}
	
	
}
