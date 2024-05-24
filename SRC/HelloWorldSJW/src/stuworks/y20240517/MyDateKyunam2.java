package stuworks.y20240517;

public class MyDateKyunam2 {
	private int day, month, year;
	private final int MONTH_OF_DAYS[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public MyDateKyunam2(int day, int month, int year) {
		super();
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

	public boolean isValid() {

		if (1 <= month && month <= 12) {
			if (1 <= day && day <= MONTH_OF_DAYS[month - 1]) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		MyDateKyunam2 myDate1 = new MyDateKyunam2(30, 2, 2000);
		
		if(myDate1.isValid()) {
			System.out.println("유효한 날짜입니다.");
		}
		else {
			System.out.println("유효한 날짜가 아닙니다.");
		}
		
		MyDateKyunam2 myDate2 = new MyDateKyunam2(30, 10, 2004);
		
		if(myDate2.isValid()) {
			System.out.println("유효한 날짜입니다.");
		}
		else {
			System.out.println("유효한 날짜가 아닙니다.");
		}
		
	}
		
}
