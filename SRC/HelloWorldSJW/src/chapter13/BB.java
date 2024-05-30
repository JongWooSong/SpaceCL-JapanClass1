package chapter13;

import chapter13.ABC.In;

public class BB {

	public static void main(String[] args) {
		
		ABC abc = new ABC();
		In in = abc.new In(); //내부 클래스 만드는 방법
		
		ABC.SSSIn sssin = new ABC.SSSIn();
		sssin.getM();
		
		ABC.SSSIn.getSM();
	}

}
