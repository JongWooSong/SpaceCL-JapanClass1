package chapter9.kyunam;

import chapter9.CalcSJW;

public class CalcTest {
	public static void main(String[] args) {
		CalcImpl c = new CalcImpl();

		c.showResult(CalcSJW.T_PLUS, 7, 3);
		c.showResult(CalcSJW.T_MINUS, 7, 3);
		c.showResult(CalcSJW.T_MULTIPLE, 7, 3);
		c.showResult(CalcSJW.T_DEVIDE, 7, 3);
	}
}

class CalcImpl extends CalcSJW {

	@Override
	public double plus(int a, int b) {
		return (a + b);
	}

	@Override
	public double minus(int a, int b) {
		return (a - b);
	}

	@Override
	public double multiple(int a, int b) {
		return (a * b);
	}

	@Override
	public double devide(int a, int b) {
		return (a / b);
	}

	@Override
	public void showResult(int type, int a, int b) {
		
		// 강사님 소스
		double result = 0;
		String op = "";
		switch (type) {
		case T_PLUS:
			result = plus(a, b);
			op = " + ";
			break;
		case T_MINUS:
			result = minus(a, b);
			op = " - ";
			break;
		case T_MULTIPLE:
			result = multiple(a, b);
			op = " * ";
			break;
		case T_DEVIDE:
			result = devide(a, b);
			op = " / ";
			break;
		}
		System.out.println(a + op + b + " = " + result);

		// 내가 짠 소스
//		if (type == T_PLUS) {
//			System.out.println(a + " + " + b + " = " + plus(a, b));
//		} else if (type == T_MINUS) {
//			System.out.println(a + " - " + b + " = " + minus(a, b));
//		} else if (type == T_MULTIPLE) {
//			System.out.println(a + " * " + b + " = " + multiple(a, b));
//		} else if (type == T_DEVIDE) {
//			System.out.println(a + " / " + b + " = " + devide(a, b));
//		}

	}

}