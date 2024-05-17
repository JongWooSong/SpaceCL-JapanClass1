package stuworks.y20240517;

public class MyDateKang {
	private int year;
	private int month;
	private int day;

	private boolean isValid = true;

	public MyDateKang(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		if (month >= 1 || month <= 12) {
			this.month = month;
		} else {
			isValid = false;
		}
	}

	public void setDay(int day) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day > 0 || day <= 31) {
				this.day = day;
			} else {
				isValid = false;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 0 || day <= 30) {
				this.day = day;
			} else {
				isValid = false;
			}
		} else if (month == 2) {
			if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) { // 윤년
				if (day < 0 || day > 29) {
					isValid = false;
				} else {
					this.day = day;
				}
			} else {
				if (day < 0 || day > 28) {
					isValid = false;
				} else {
					this.day = day;
				}
			}
		}
	}
	
	public String isValid() {
		return isValid ? "유효한 날짜" : "유효하지 않은 날짜";
	}
	
	public static void main(String[] args) {
		MyDateKang d1 = new MyDateKang(2000, 2, 30);
		System.out.println(d1.isValid());
		MyDateKang d2 = new MyDateKang(2006, 10, 2);
		System.out.println(d2.isValid());	
	}
}

