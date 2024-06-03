package chapter16;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Random;

public class Horse extends Thread {
	
	private static Canvas canvas;
	private int y = 0;
	private String str = null;
	private Random rand = new Random(); //임의 숫자를 랜덤하게 발생시켜주는 클래스
	private int horseRunRange = 0; //말이 뛴 거리
	private boolean isRankEnd = false; //등수가 매겨졌는지에 대한 판별
	
	public Horse(Canvas canvas, int num, String name) {
		if(this.canvas == null) {
			this.canvas = canvas;	
		}
		this.y = num;
		this.str = name;
	}

	public void setIsRandEnd(boolean rankEnd) {
		this.isRankEnd = rankEnd;
	}
	
	public boolean getIsRankEnd() {
		return isRankEnd;
	}
	
	public int getHourseRunRange() {
		return horseRunRange;
	}
	
	public String getHorseName() {
		return str;
	}
	
	@Override
	public void run() {
		Graphics g = canvas.getGraphics();
		g.drawString(str, 20, y);
		for(int i=0; i<300; i++) {
			
			try {
				Thread.sleep(100); //0.1 초 자겠다.
				i += rand.nextInt(9); 
				horseRunRange = i;
				//각 말들은 0.1초 가격으로 0부터 5까지의 랜덤한 숫자거리로 달리게 된다.
				
				if( i > 300 ) {
					i = 300; //말의 종료지점으로 옮긴다.
				}
				g.fillRect(50, y, i, 20);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}//end for
		
		//경기종료 
		System.out.println( HorseTest.addRank() + "등 말은 " + this.str );
		
	}//end run()
	
	
}
