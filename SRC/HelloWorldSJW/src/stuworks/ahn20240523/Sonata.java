package stuworks.ahn20240523;

public class Sonata extends Car {

	final private String CAR_NAME = "Sonata";
	
	@Override
	void start() {
		this.getClass().getSimpleName();
		System.out.println(CAR_NAME + " 시동을 켭니다.");
	}

	@Override
	void drive() {
		System.out.println(CAR_NAME + " 달립니다.");
	}

	@Override
	void stop() {
		System.out.println(CAR_NAME + " 멈춥니다.");
	}

	@Override
	void turnoff() {
		System.out.println(CAR_NAME + " 시동을 끕니다.");
	}

}
