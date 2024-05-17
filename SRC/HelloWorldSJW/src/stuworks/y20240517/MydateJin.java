package stuworks.y20240517;

public class MydateJin {

	private  int day, month , year; // 변수를 private 선언 ----1
	private final int MONTH_OF_DAY [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
	public  MydateJin() { // 생성자만들고---2

	}
	public MydateJin(int day, int month, int year) {//객체자 생성---3
		this.day =day;
		this.month =month;
		this.year =year;
		}

		public int getDay() { // get/set은 변수 선언 후 source -> setget메뉴---2
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}

	//날짜가 유효한지 아닌지를 boolean 으로 반환
	public boolean isValid() {// ---5 조건 생성
		if(month>=1&& month<=12) {// 월 체크
			if(day>=1&&day<= MONTH_OF_DAY[month-1]) {	// 배열
				return true;
			}else if (day <= 29 &&year%4==0||year%10==0) { // 4년주기로 2월29일체크
				return true;
			}
		}
		return false;}
	
		public static void main(String[] arg) {
			MydateJin mj = new MydateJin(28, 2, 208);
			System.out.println(mj.isValid());
			if(mj.isValid()) {
				System.out.println("유효한 날짜입니다.");
			}else {
				System.out.println("유효하지 않은 날짜입니다.");
			}
		}
	}

	 
	

	
	


