package chapter16;

import java.awt.Canvas;
import java.awt.Frame;
import java.util.ArrayList;

public class HorseTest {
	
	private static int horseRank = 0;
	
	public synchronized static int addRank() {
		horseRank++;
		return horseRank;
	}
	
	public static void main(String[] args) {
		
		Frame frm = new Frame("쓰레드 경마장");
		Canvas canvas = new Canvas();
		
		frm.setSize(400, 400);
		frm.add(canvas);
		frm.setVisible(true);
		
		Horse h1 = new Horse(canvas, 30, "1번말");
		Horse h2 = new Horse(canvas, 70, "2번말");
		Horse h3 = new Horse(canvas, 110, "3번말");
		Horse h4 = new Horse(canvas, 150, "4번말");
		Horse h5 = new Horse(canvas, 190, "5번말");
		Horse h6 = new Horse(canvas, 230, "6번말");
		Horse h7 = new Horse(canvas, 270, "7번말");
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		h6.start();
		h7.start();
	}

}
