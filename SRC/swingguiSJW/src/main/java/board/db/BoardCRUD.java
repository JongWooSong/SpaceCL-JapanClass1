package board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class BoardCRUD extends CommonCRUD {

	public static void main(String[] args) {
		System.out.println(new BoardCRUD().getTotalListCnt(""));
	}

	// TODO board 테이블에 boardBean 값을 insert 데이터 하는
	// 코드를 작성 하시오. (= insertMember() 참고해라)
	public int insertBoard(BoardBean bean) {

		Connection conn = getConnection();
		int cnt = 0;

		try {
			// 3.쿼리준비
			String sql = "INSERT INTO board(title, contents, member_no) VALUES(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// 4.데이터 binding
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getContents());
			pstmt.setString(3, bean.getMemberNo());

			// 5.쿼리실행
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	/**
	 * 전체 게시물의 갯수를 구한다.
	 * 
	 * @return
	 */
	public int getTotalListCnt(String searchWord) {
		Connection conn = getConnection();
		int cnt = 0;

		try {
			// 3.쿼리 수행을 위한 Statment 객체 생성
			Statement stmt = conn.createStatement();

			// 4.쿼리 작성
			String sql = "select count(*) from board" + " where title like '%" + searchWord + "%'"
					+ " or contents like '%" + searchWord + "%'";

			// 5.쿼리수행
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	/**
	 * 리스트 취득
	 * 
	 * @param pageNo 0:(최신목록 10개만 가져온다), 숫자: 해당 페이지를 목록으로 취득
	 * @return
	 */
	public List<BoardBean> getBoardList(int pageNo, String searchWord) {

		Connection conn = getConnection();
		List<BoardBean> list = new ArrayList<BoardBean>();
		int startOffset = ((pageNo - 1) * 10); // 공식

		try {
			// 3.쿼리 수행을 위한 Statment 객체 생성
			Statement stmt = conn.createStatement();

			// 4.쿼리 작성
			String sql = " select " + " board_no, title, contents, count, secret_yn, member_no, "
					+ " (select name from member where member_no = b.member_no) memberName, " + " reg_dt "
					+ " from board b " + " where title like '%" + searchWord + "%'" + " or contents like '%"
					+ searchWord + "%'" + " order by board_no desc " + " limit " + startOffset + ", 10";

			System.out.println(sql);

			// 5.쿼리수행
			ResultSet rs = stmt.executeQuery(sql);

			// 6.쿼리 실행결과 출력하기
			while (rs.next()) { // 1개의 row 씩 진행
				BoardBean bean = new BoardBean();
				bean.setBoardNo(rs.getString("board_no"));
				bean.setTitle(rs.getString("title"));
				bean.setContents(rs.getString("contents"));
				bean.setCount(rs.getString("count"));
				bean.setSecretYn(rs.getString("secret_yn"));
				bean.setMemberNo(rs.getString("member_no"));
				bean.setMemberName(rs.getString("memberName"));
				bean.setRegDt(rs.getString("reg_dt"));

				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}// end method

	/**
	 * 1건의 상세 게시물을 취득한다.
	 * 
	 * @param boardNo
	 * @return
	 */
	public BoardBean getBoard(String boardNo) {

		Connection conn = getConnection();
		BoardBean bean = new BoardBean();

		try {
			// 3.쿼리 수행을 위한 Statment 객체 생성
			Statement stmt = conn.createStatement();

			// 4.쿼리 작성
			String sql = " select " + " board_no, title, contents, count, secret_yn, member_no, "
					+ " (select name from member where member_no = b.member_no) memberName, " + " reg_dt "
					+ " from board b " + " where board_no = " + boardNo;

			// 5.쿼리수행
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				// 1건조회
				bean.setBoardNo(rs.getString("board_no"));
				bean.setTitle(rs.getString("title"));
				bean.setContents(rs.getString("contents"));
				bean.setCount(rs.getString("count"));
				bean.setSecretYn(rs.getString("secret_yn"));
				bean.setMemberNo(rs.getString("member_no"));
				bean.setMemberName(rs.getString("memberName"));
				bean.setRegDt(rs.getString("reg_dt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}// end method

	/**
	 * 1건 업데이트 
	 * @param boardBean
	 * @return 업데이트된 row 수
	 */
	public int updateBoard(BoardBean boardBean) {
		
		int cntRow = 0;
		Connection conn = getConnection();
		
		//값이 안오면 바로 리턴
		if( StringUtils.isEmpty(boardBean.getBoardNo()) ) {
			return cntRow;
		}
		
		try {
			//3.쿼리준비
			String sql = "UPDATE board set reg_dt = now() ";
			
			if( StringUtils.isNotEmpty(boardBean.getTitle()) ) {
				sql += ", title = '" + boardBean.getTitle() + "'";
			}
			if( StringUtils.isNotEmpty(boardBean.getContents()) ) {
				sql += ", contents = '" + boardBean.getContents() + "'";
			}
			if( StringUtils.isNotEmpty(boardBean.getCount()) ) {
				sql += ", count = '" + boardBean.getCount() + "'";
			}
			sql += " where board_no = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4.데이터 binding
			pstmt.setString(1, boardBean.getBoardNo() );
			
			//5.쿼리실행 
			cntRow = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cntRow;
		
	}// end method

	/**
	 * 1건 삭제
	 * 
	 * @param boardNo
	 * @return 삭제된 row 수
	 */
	public int delBoard(String boardNo) {

		int cntRow = 0;
		Connection conn = getConnection();
		
		//값이 안오면 바로 리턴
		if( StringUtils.isEmpty(boardNo) ) {
			return cntRow;
		}
		
		try {
			//3.쿼리준비
			String sql = "DELETE FROM board WHERE board_no = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4.데이터 binding
			pstmt.setString(1, boardNo );
			
			//5.쿼리실행 
			cntRow = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cntRow;
		
	}// end method

}
