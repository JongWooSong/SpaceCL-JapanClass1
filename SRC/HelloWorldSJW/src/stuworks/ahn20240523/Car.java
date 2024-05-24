package stuworks.ahn20240523;

public abstract class Car {
	abstract void start();
	abstract void drive();
	abstract void stop();
	abstract void turnoff();
	
	final public void run() {
		start();
		drive();
		stop();
		turnoff();
		carWash();
	}
	
	public void carWash() {
		System.out.println("세차를 합니다.");
	}
}
