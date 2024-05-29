package chapter12.exam.song;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import chapter12.exam.Book;
import chapter12.exam.SchoolLibrary;

public class SongSchoolLib extends SchoolLibrary {

	private Map<String, Book> mLibMap = new HashMap<String, Book>();
	
	@Override
	public void addBook(Book book) {
		mLibMap.put(book.getTitle(), book);
	}

	@Override
	public String getBookTitleList() {
		//홍길동전, 가상전, 윤석열전...
		return null;
	}

	@Override
	public Book getBookByTitle(String bookTitle) {
		return mLibMap.get(bookTitle);
	}

	@Override
	public Book getBookByAuthor(String author) {
		Iterator<String> it = mLibMap.keySet().iterator();
		Book rtnBook = null;
		
		while(it.hasNext()) {
			String title = it.next();	//key
			Book book = mLibMap.get(title); //value
			if( author.equals(book.getAuthor()) ) {
				rtnBook = book;
				break;
			}
		}
		
		return rtnBook;
	}

	@Override
	public int getBookNum() {
		return mLibMap.size();
	}

}
