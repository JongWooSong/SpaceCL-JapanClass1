package chapter11;

public class CodeBlocks {

	private static String aField = "";
	private String bField = "";

	static {
		aField += "A";
	}

	{ //생성자 보다 먼저 실행되는 멤버변수 초기화 차리 
		aField += "B";
		bField += "B";
	}
	
	public CodeBlocks() {
		aField += "C";
		bField += "C";
	}

	public void append() {
		aField += "D";
		bField += "D";
	}
	
	public static void main(String[] args) {
		System.out.println(aField);

		CodeBlocks cb = new CodeBlocks();
		cb.append();

//		System.out.println(aField);
//		System.out.println(cb.bField);
//		

		Integer a = new Integer(2); 
		Integer b = new Integer(2); 
		System.out.println( a == b );
		
		int aaa = 9 / 0; 
		 int a1 = 5; 
		double a2 = (float)a1; 
	}
	
	@Override
	protected void finalize() throws Throwable {
		aField = null;
	}

}
