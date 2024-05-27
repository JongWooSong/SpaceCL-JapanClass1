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

		System.out.println(aField);
		System.out.println(cb.bField);
	}

}
