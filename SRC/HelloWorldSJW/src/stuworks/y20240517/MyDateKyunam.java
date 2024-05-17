package stuworks.y20240517;

public class MyDateKyunam {
	private int day;
	private int month;
	private int year;

	MyDateKyunam(int day, int month, int year) {
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
		boolean valid = false;

		// 달마다 날짜가 유효한지 체크하는 소스... 무식하게 길..
		switch (month) {
		case 1:
			if (day <= 0 || day > 31) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 2:
			if (day <= 0 || day > 28) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 3:
			if (day <= 0 || day > 31) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 4:
			if (day <= 0 || day > 30) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 5:
			if (day <= 0 || day > 31) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 6:
			if (day <= 0 || day > 30) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 7:
			if (day <= 0 || day > 31) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 8:
			if (day <= 0 || day > 31) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 9:
			if (day <= 0 || day > 30) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 10:
			if (day <= 0 || day > 31) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 11:
			if (day <= 0 || day > 30) {
				System.out.println("유효하지 않은 날짜입니다.");
			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		case 12:
			if (day <= 0 || day > 31) {
				System.out.println("유효하지 않은 날짜입니다.");

			} else {
				System.out.println("유효한 날짜입니다.");
				valid = true;
			}
			break;
		}

		return valid;
	}

	public static void main(String[] args) {
		MyDateKyunam date1 = new MyDateKyunam(30, 2, 2000);
		System.out.println(date1.isValid());

		MyDateKyunam date2 = new MyDateKyunam(2, 10, 2006);
		System.out.println(date2.isValid());
	}

}
