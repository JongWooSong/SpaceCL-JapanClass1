package chapter2;

public class Variable1 {

	public static void main(String[] args) {
		//final int level = 10;
		byte Level;
		//Level = -129;
		
		short num = 32767;
		int intnum1 = 2147;
		int intnum2 = intnum1 * num;
				
		System.out.println(intnum2);

		long longnum3 = 10l;
		
		float fnum1 = 0.00001f;
		double dnum1 = 0.00001;
		
		long plusLong1 =  intnum1 + longnum3;
		System.out.println(plusLong1);
		
		//float plusfd1 = fnum1 + dnum1;
		char ch1 = 'A';
		char ch2 = '한';
		char ch3 = 97;
		String str1 = "안녕하세요";
		
		System.out.println(ch3);
		
		
		int ch4 = 200;
		System.out.println((byte)ch4);
		
		
		//System.out.println(str1 + ch1 + ch2);

		
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = !b1;
		boolean b4 = !!b3;
		
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println(b3);
		System.out.println(b4);
		
		
		
		
	}

}
