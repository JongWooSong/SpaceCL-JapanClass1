package chapter9.Jeon240523.quize;

public class Grandeur extends Car {
	

	public void start() {
		System.out.println(this.getClass().getSimpleName() +" Engine On.");
	}
	
	public void drive() {
		System.out.println(this.getClass().getSimpleName() +" Drive.");
	}
	
	public void stop() {
		System.out.println(this.getClass().getSimpleName() +" Stop.");
	}
	
	public void turnoff() {
		System.out.println(this.getClass().getSimpleName() +" Engine Off.");
	}

	public void washCar() {
		System.out.println("Washing Car.");
	}

}
