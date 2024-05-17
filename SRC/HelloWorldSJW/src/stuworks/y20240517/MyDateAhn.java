package stuworks.y20240517;

public class MyDateAhn {
	private int day;
	private int month;
	private int year;
	final int checkDay[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};   
	
	public MyDateAhn(int day, int month, int year) {
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
		if(month <= 0 || month > 12) {
			return false;
		}
		if(day <= 0 || day > checkDay[month - 1]) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		MyDateAhn date1 = new MyDateAhn(30, 2, 2000);
		String result = printResult(date1.isValid());
		System.out.println(result);
		
		MyDateAhn date2 = new MyDateAhn(2, 10, 2006);
		result = printResult(date2.isValid());
		System.out.println(result);
	}
	
	private static String printResult(boolean valid) {
		return valid ? "유효한 날짜입니다." : "유효하지 않은 날짜입니다.";
	}
	
}
