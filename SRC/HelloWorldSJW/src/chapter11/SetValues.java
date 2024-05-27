package chapter11;

public class SetValues {

	public static void main(String[] args) {

		String stringObj = "Hello";
		int intValue = 0;
		Float floatObj = new Float(1.0);
		Q4 q4 = new Q4();
		
		setValues(q4, stringObj, intValue, floatObj);
		System.out.println(q4.testStr + ", " + stringObj + ", "
				+ intValue + ", " + floatObj );

	}

	private static void setValues(Q4 q4, String strValue, int intValue, Float floatObj) {
		q4.testStr = "안녀하세요?";
		strValue.replace("H", "h");
		strValue += " World";
		intValue = 99;
		floatObj = floatObj.valueOf((float) 2.0);
	}
}
