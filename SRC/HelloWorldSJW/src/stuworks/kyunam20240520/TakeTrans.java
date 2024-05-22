package stuworks.kyunam20240520;

public class TakeTrans {

	public static void main(String[] args) {
		
		/**
		 * 버스	970 번 (요금   100 원)
		 * 		200 번 (요금   500 원)
		 * 전철	3 호선 (요금 1,000 원)
		 * 		9 호선 (요금 1,500 원)
		 */
		
//		Student stu1 = new Student("James", 5000);
//		Student stu2 = new Student("Tomas", 10000);
//
//		Bus bus970 = new Bus(970, 100);	// 100원 
//		Bus bus200 = new Bus(200, 500);	// 500원
//		Subway subway3 = new Subway("3", 1000);	// 1000 원
//		Subway subway9 = new Subway("9", 1500);	// 1500 원
//		
//		stu1.takeBus(bus970);
//		stu1.takeBusOff(bus970);
//		stu1.takeBus(bus200);
//		stu1.takeBusOff(bus200);
//		stu1.takeSubway(subway9);
//		stu1.takeBusOff(subway9);
//		
//		stu1.showInfo();
//		
//		stu2.takeBus(bus970);
//		stu2.takeSubway(subway3);
//		stu2.takeSubway(subway9);
//		stu2.showInfo();

		Student stu1 = new Student("James", 5000);
		Student stu2 = new Student("Tomas", 10000);
		
		Bus bus970 = new Bus(970, 100); //970번 버스 --> 100원 
		Bus bus200 = new Bus(200, 500); //200번 버스 --> 500원
		Subway subway3 = new Subway("3", 1000);  // 1000원 차감
		Subway subway9 = new Subway("9", 1500);  // 1500원 차감 

		//Stduent James
		stu1.takeBus(bus970); //버스 타고 100
		stu1.takeBusOff(bus970); //버스에서 내린다.
		stu1.takeSubway(subway3); //지하철 타고 --> 500 
		//문제: 지하철이나 버스를 먼저 탔던 다음 대중교통 이용시 50% 할인 
		stu1.takeSubwayOff(subway3); //지하철에서 내린다.
		stu1.showInfo(); //현재 남은돈 출력 4400
		
		//Stduent Tomas
		stu2.takeSubway(subway9); //지하철 타고 1500
		stu2.takeSubwayOff(subway9);
		
		stu2.takeSubway(subway3); //지하철 타고 --> 지하철 끼리는 공짜
		stu2.takeSubwayOff(subway3);
		
		stu2.takeBus(bus970); //버스 타고 --> 버스값 50% 할인  50 
		stu1.takeBusOff(bus970); //버스에서 내린다.
		
		stu2.showInfo(); //현재 남은돈 출력
		
	} // end main

}
