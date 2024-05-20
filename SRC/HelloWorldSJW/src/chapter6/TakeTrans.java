package chapter6;

public class TakeTrans {

	public static void main(String[] args) {
		
		
		Student stu1 = new Student("James", 5000);
		Student stu2 = new Student("Tomas", 10000);
		
		Bus bus970 = new Bus(970, 100); //970번 버스 --> 100원 
		Bus bus200 = new Bus(200, 500); //200번 버스 --> 500원
		Subway subway3 = new Subway("3", 1000);  // 1000원 차감
		Subway subway9 = new Subway("9", 1500);  // 1500원 차감 
		
		stu1.takeBus(bus970); //버스 타고 
		stu1.takeBus(bus200); //버스 타고
		stu1.takeSubway(subway3); //지하철 타고
		stu1.takeSubway(subway9); //지하철 타고
		
		stu1.takeBusOff(bus970); //버스에서 내린다.
		
		stu1.showInfo(); //현재 남은돈 출력
		

		stu2.takeBus(bus970); //버스 타고 
		stu2.takeSubway(subway3); //지하철 타고
		stu2.takeSubway(subway9); //지하철 타고
		stu2.showInfo(); //현재 남은돈 출력
		
	}

}
