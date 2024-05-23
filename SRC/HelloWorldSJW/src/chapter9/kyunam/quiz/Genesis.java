package chapter9.kyunam.quiz;

public class Genesis extends Car {

	@Override
	void start() {
		System.out.println(this.getClass().getSimpleName() + " 시동을 켭니다.");
	}

	@Override
	void drive() {
		System.out.println(this.getClass().getSimpleName() + " 달립니다.");
	}

	@Override
	void stop() {
		System.out.println(this.getClass().getSimpleName() + " 멈춥니다.");
	}

	@Override
	void turnOff() {
		System.out.println(this.getClass().getSimpleName() + " 시동을 끕니다.");
	}

}
