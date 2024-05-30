package chapter12.exam.song;

import chapter12.exam.Book;

public class Test {
	public static void main(String[] args) {

		Book book = new Book();
		book.setTitle("홍길동전");
		book.setAuthor("홍길동");
		Book book2 = new Book();
		book2.setTitle("비극");
		book2.setAuthor("강동원");
		Book book3 = new Book();
		book3.setTitle("희망");
		book3.setAuthor("원빈");
		Book book4 = new Book();
		book4.setTitle("취업");
		book4.setAuthor("김남길");
		Book book5 = new Book();
		book5.setTitle("메뉴얼");
		book5.setAuthor("이병헌");

		SchoolLibraryExtends sle = new SchoolLibraryExtends();
		sle.addBook(book);
		sle.addBook(book2);
		sle.addBook(book3);
		sle.addBook(book4);
		sle.addBook(book5);

		Book testBook = sle.getBookByTitle("비극");
		System.out.println("타이틀 : " + testBook.getTitle());

		Book testBook2 = sle.getBookByAuthor("원빈");
		System.out.println("저자 : " + testBook2.getTitle());
		
		System.out.println("책 보유 리스트: " + sle.getBookTitleList());
		
		System.out.println("책 보유수: " + sle.getBookNum());

	}
}//end class


class A {
	
}
