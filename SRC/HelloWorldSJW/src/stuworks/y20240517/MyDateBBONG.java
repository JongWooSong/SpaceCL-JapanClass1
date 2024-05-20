package stuworks.y20240517;

public class MyDateBBONG {

	private int day, month, year;
	
	private final int MONTH_OF_DAYS[] = { 30, 28, 31, 30, 30, 31, 30, 31, 30, 31, 30, 31 }; 
	
	//생성자 - Constructor
	public MyDateBBONG() {
		
	}
	
	public MyDateBBONG(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	
	public int getDay() {
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

	//날짜가 유효한지 아닌지를 boolean 으로 반환해라
	public boolean isValid() {
		
		//월 체크 
		if( month >= 1 && month <= 12 ) {
			
			//일 체크(시작은 무조건 1보다 커야된다. 
			//끝날자는 배열에 해달월의 날짜보다 작아야한다.)
			if( day >= 1 && day <= MONTH_OF_DAYS[month-1] ) {
				return true;
			}
			
		}
		
		return false;
	}
	

	public static void main(String[] args) {
		
		MyDateBBONG mb = new MyDateBBONG(39, 3, 2000);
		
		if( mb.isValid() ) {
			System.out.println("유효한 날짜 입니다.");
		}
		else {
			System.out.println("유효하지 않은 날짜 입니다.");
		}
	}

}
