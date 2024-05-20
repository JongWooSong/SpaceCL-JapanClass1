package stuworks.y20240517;

public class MyDateLSY {
	
	private int day;
	private int month;
	private int year;
	
	private final int MONTH_OF_DAYS [] = { 30, 28, 31 , 30, 30, 31, 30, 31, 30, 31, 30, 31};
 	
	//생성자 - constructor
	public MyDateLSY() {
		
	}
	
	public MyDateLSY(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year; 
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day =day;	
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
	
	//날짜가 유효한지 아닌지를 boolean으로 변환
	public boolean isValid() {
		
		if ( month >= 1 && month <= 12) {
			
			if (day  >= 1 && MONTH_OF_DAYS [month -1] <= day ) {
				return true;
			}
			
		
			
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		
		MyDateLSY mb = new MyDateLSY(28, 2, 2000);
	
		if( mb.isValid()) {
			System.out.println("유효한 날짜 입니다");
		}
		else {
			System.out.println("유효하지 않은 날짜 입니다");
		}
		
	
	
	
		
	
	
	
	
		
		
	}

}
