package stuworks.y20240517;

public class MyDateJeon {

	private int day;
	private int month;
	private int year;
	
	private int MONTHS_DAYS[]= {31,28,30,31,30,31,30,31,30,31,30,31};

	public MyDateJeon(int day, int month, int year){
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
		
		if(month <1 || MONTHS_DAYS[month-1]<day)
			return false;
		if(month >12)
			return false;
		return true;
	}
		
	public static void main(String[] args) {

		MyDateJeon date1 = new MyDateJeon(30,2,2000);
		System.out.println(date1.isValid());
		if (date1.isValid()==true) {
			System.out.println("유효한 날짜 입니다.");
		}
		else
			System.out.println("유효하지 않은 날짜 입니다.");
		MyDateJeon date2 = new MyDateJeon(2,10,2006);
		System.out.println(date2.isValid());
		if (date2.isValid()==true) {
			System.out.println("유효한 날짜 입니다.");
		}
		else
			System.out.println("유효하지 않은 날짜 입니다.");
	}

}
