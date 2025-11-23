package tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5.PaperBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Member;
import lab5.Book;

class TestBorrowBooks {

	Member member1;
	Member member2;
	
	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice"); // flush borrowedBook array 
		member2 = new Member("Bob");   // flush borrowedBook array 
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
	}
	@Test
	void borrowBookBook() {
		
		// borrow first book
		assertEquals(0, member1.borrowedBooksCount(), "Borrowed book should be zero");
		assertTrue(book1.getIsAvailable(), "Book 1 must be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(),"Book 1 must be not available");
		assertEquals(1, member1.borrowedBooksCount(), "Count of borrowed books must be 1");
		
		// borrow second book
		assertTrue(book2.getIsAvailable(),"Book must be available");
		member1.borrowBook(book2);
		assertFalse(book1.getIsAvailable(), "Book should not be available");
		assertEquals(2, member1.borrowedBooksCount(), "The book coubnt shoud be 2");
	}
	
	@Test
	void returnBookBook() {
		
		// borrow two books
		assertTrue(book1.getIsAvailable(), "Book 1 should be available");
		assertTrue(book2.getIsAvailable(), "Book 2 should be available");
		assertEquals(0, member1.borrowedBooksCount(),"Member1 should not have any books" );
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		assertEquals(2, member1.borrowedBooksCount(), "The count of books must be 2");
		assertFalse(book1.getIsAvailable(), "Book 1 should not be available");
		assertFalse(book2.getIsAvailable(), "Book 2 should not be available");
		
		// return first book
		member1.returnBook(book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		assertEquals(1, member1.borrowedBooksCount(), "Count of books must be 1");
		// return second book
		member1.returnBook(book2);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(0, member1.borrowedBooksCount(), "Member 1 should have no books");
		
	}

}
