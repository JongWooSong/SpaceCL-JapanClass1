package chapter12.exam.kyunam;

import java.util.HashMap;
import java.util.Iterator;

import chapter12.exam.Book;
import chapter12.exam.SchoolLibrary;

public class SchoolLibraryExtends extends SchoolLibrary {

	//
	HashMap<String, Book> map = new HashMap<String, Book>();

	@Override
	public void addBook(Book book) {
		map.put(book.getTitle(), book);
		map.put(book.getAuthor(), book);
		System.out.println(book.getTitle() + " 책이 추가되었습니다.");
	}

	@Override
	public String getBookTitleList() {
		
		String titleList = "";
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			String title = (String) it.next(); 
			titleList += title + ", ";
		}
		
		return titleList;
	}

	@Override
	public Book getBookByTitle(String bookTitle) {
		
		Book book = null;
		
		if (map.get(bookTitle) != null) {
			book = map.get(bookTitle);
		}
		
		return book;
	}
	
	@Override
	public int getBookNum() {

		int bookNum = 0;
		Iterator it = map.keySet().iterator();
		
		while (it.hasNext()) {
			bookNum++;
		}

		return bookNum;
	}

	@Override
	public Book getBookByAuthor(String author) {
		
		Book book = null;
		
		if (map.get(author) != null) {
			book = map.get(author);
		}
		
		return book;
	}

}
