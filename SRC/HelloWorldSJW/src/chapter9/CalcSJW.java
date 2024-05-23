package chapter9;

public abstract class CalcSJW {

	public static final int T_PLUS = 0;
	public static final int T_MINUS = 1;
	public static final int T_MULTIPLE = 2;
	public static final int T_DEVIDE = 3;
	
	public abstract double plus(int a, int b);
	
	public abstract double minus(int a, int b);
	
	public abstract double multiple(int a, int b);
	
	public abstract double devide(int a, int b);
	
	public abstract void showResult(int type, int a, int b);
	
}
