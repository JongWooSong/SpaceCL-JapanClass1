package stuworks.y20240517;

public class MyDateSMJ {
	
	private int day, month, year;
	private final int MONTH_OF_DAYS[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
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
	
	public MyDateSMJ() {
	}
	
	public MyDateSMJ(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean isValid() {
		// 월 체크
		if (month >= 1 && month <= 12) {
			// 일 체크 (시작은 무조건 1보다 커야 된다. 끝날짜는 배열에 해당 월의 날짜보다 작아야 한다.)
			if (day >= 1 && day <= MONTH_OF_DAYS[month - 1]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MyDateSMJ date1 = new MyDateSMJ(31, 8, 2000);
		System.out.println(date1.isValid());
		MyDateSMJ date2 = new MyDateSMJ(2, 10, 2006);
		System.out.println(date2.isValid());
	}
} // end class