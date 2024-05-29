package chapter12.exam;

public abstract class SchoolLibrary {

	/** 책 추가 **/
	public abstract void addBook(Book book);
	
	/** 책 타이틀 목록 **/
	public abstract String getBookTitleList();
	
	/** 책 찾기 by title or author **/
	public abstract Book getBook(String bookTitle, String author);
	
	/** 도서관 보유 전체 책 수 **/
	public abstract int getBookNum();
	
}
