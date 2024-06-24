package board.db;

import lombok.Data;

@Data
public class BoardBean {

	private String boardNo;
	private String title;
	private String contents;
	private String count;
	private String secretYn;
	private String memberNo;
	private String memberName;
	private String regDt;
	
}
