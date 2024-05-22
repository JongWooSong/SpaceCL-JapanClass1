package stuworks.ahn20240520;

public class TakeTrans {
	
	public static void main(String[] args) {
		// 학생 두 명 생성
		Student stu1 = new Student("James", 5000);
		Student stu2 = new Student("Tomas", 10000);
		
		stu1.serialNum = 20;
//		System.out.println(stu2.serialNum);
		
		Bus bus970 = new Bus(970, 100); // 970번 버스 --> 100원
		Bus bus200 = new Bus(200, 500); // 200번 버스 --> 500원
		Subway subway3 = new Subway("3", 1000); // 1000원 차감
		Subway subway9 = new Subway("9", 1500); // 1500원 차감
		
		// TODO 24.05.20 과제
		// Student James
		stu1.takeBus(bus970); // 버스 타고
		stu1.takeBusOff(bus970); // 버스에서 내린다.
		stu1.takeSubway(subway3); // 지하철 타고 -->
		// 문제: 지하철이나 버스를 먼저 탔던 다음 대중교통 이용시 50% 할인
		stu1.takeSubwayOff(subway3); // 지하철에서 내린다.
		stu1.showInfo(); // 현재 남은 돈 출력
		
		System.out.println();
		
		// Student Tomas
		stu2.takeSubway(subway9);
		stu2.takeSubwayOff(subway9);
		stu2.takeSubway(subway3); // 지하철끼리는 공짜
		stu2.takeSubwayOff(subway3); 
		stu2.takeBus(bus970); // 버스타고 --> 버스값 50% 할인
		stu2.takeBusOff(bus970);
		
		stu2.showInfo();
	} // end main
} // end class
