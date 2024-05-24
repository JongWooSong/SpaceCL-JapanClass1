package chapter9.kyunam.quiz;

public abstract class Car {

	abstract void start();

	abstract void drive();

	abstract void stop();

	abstract void turnOff();

	final void run() {
		start();
		drive();
		stop();
		turnOff();
	}

	public void washCar() {
		System.out.println("세차를 합니다.");
	}
}
