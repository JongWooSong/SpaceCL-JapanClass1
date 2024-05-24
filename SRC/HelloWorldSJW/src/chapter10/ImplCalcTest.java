package chapter10;

import java.util.ArrayList;
import java.util.List;

public class ImplCalcTest {

	public static void main(String[] args) {

		Calc cal1 = new ImplCalc();
		Calc2 cal2 = new ImplCalc();
		ImplCalc cal3 = new ImplCalc();
		Object cal4 = new ImplCalc();
		
		cal3.clacP( cal3 );
	
		Iterable<String> l = new ArrayList<String>();
		
	}

}
