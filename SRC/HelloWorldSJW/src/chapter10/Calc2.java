package chapter10;

public interface Calc2  {

	final double PI = 3.14;
	final int ERROR = -999999;
	
	int times(int a, int b);
	int divide(int a, int b);
	void clacP(Calc c);
	
	default void description() {
		System.out.println("정수 계산기를 구현합니다.");
	}
}
