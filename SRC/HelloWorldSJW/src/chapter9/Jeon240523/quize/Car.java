package chapter9.Jeon240523.quize;

public abstract class Car {

	public abstract void start();
	public abstract void drive();
	public abstract void stop();
	public abstract void turnoff();
	public abstract void washCar();
	

	final public void run() {
		start();
		drive();
		stop();
		turnoff();
		washCar();
	}
	
}
