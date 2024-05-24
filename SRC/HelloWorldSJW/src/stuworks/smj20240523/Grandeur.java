package stuworks.smj20240523;

public class Grandeur extends Car {

	@Override
	public void startCar() {
		System.out.println("Grandeur 시동을 켭니다.");
	}

	@Override
	public void drive() {
		System.out.println("Grandeur 달립니다.");
	}

	@Override
	public void stop() {
		System.out.println("Grandeur 멈춥니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Grandeur 시동을 끕니다.");
	}

}
