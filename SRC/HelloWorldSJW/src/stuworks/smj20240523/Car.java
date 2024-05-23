package stuworks.smj20240523;

public abstract class Car {
	
	public abstract void startCar();
	public abstract void drive();
	public abstract void stop();
	public abstract void turnOff();
	
	void washCar() {
		System.out.println("세차를 합니다");
	}
	
	final public void run() {
		startCar();
		drive();
		stop();
		turnOff();
		washCar();
	}
	
}
