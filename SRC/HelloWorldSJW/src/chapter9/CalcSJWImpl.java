package chapter9;

public class CalcSJWImpl extends CalcSJW {

	@Override
	public double plus(int a, int b) {
		return a + b;
	}

	@Override
	public double minus(int a, int b) {
		return a - b;
	}

	@Override
	public double multiple(int a, int b) {
		return a * b;
	}

	@Override
	public double devide(int a, int b) {
		return a / b;
	}

	@Override
	public void showResult(int type, int a, int b) {
		
		double ret = 0;
		String op = "";
		
		switch (type) {
		case T_PLUS:
			ret = plus(a, b);
			op = "+";
			break;
		case T_MINUS:
			ret = minus(a, b);
			op = "-";
			break;
		case T_MULTIPLE:
			ret = multiple(a, b);
			op = "*";
			break;
		case T_DEVIDE:
			ret = devide(a, b);
			op = "/";
			break;
		}//end switch
		
		System.out.println( a + op + b + "=" + ret );
	}

	public static void main(String[] args) {
		
		CalcSJWImpl calc = new CalcSJWImpl();
		calc.showResult(T_PLUS, 10, 20);
		
		calc.showResult(T_MINUS, 10, 20);
		
		calc.showResult(T_MULTIPLE, 10, 20);
		
		calc.showResult(T_DEVIDE, 10, 20);
		
	}
	
	
	
}
