package chapter9.kyunam.quiz;

import java.util.ArrayList;

public class CarTest {

	public static void main(String[] args) {
		ArrayList<Car> carList = new ArrayList<Car>();

		carList.add(new Sonata());
		carList.add(new Grandeur());
		carList.add(new Avante());
		carList.add(new Genesis());

		for (Car car : carList) {
			car.run();
			car.washCar();
			System.out.println("=======================");
		}
	}
}
