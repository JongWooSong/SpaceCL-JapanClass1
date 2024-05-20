package stuworks.y20240517;

public class MyDateSMJ {
	
	private int day;
	private int month;
	private int year;
	
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
	
	public MyDateSMJ(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean isValid() {
		
		if (month < 1 || month > 12) {
			return false;
		}
		
		if (month == 2) {
			if (day < 1 || day > 28) {
				return false;
			}
		}
		
			return true;
		}

	
	public static void main(String[] args) {

		MyDateSMJ date1 = new MyDateSMJ(30, 2, 2000);
		System.out.println(date1.isValid());
		MyDateSMJ date2 = new MyDateSMJ(2, 10, 2006);
		System.out.println(date2.isValid());
		
	}
	
	
	
} // end class