package tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNotAvailableBook {

	Member member1;
	Member member2;
	
	Book book1 = new PaperBook("Dune");
	//Book book2 = new PaperBook("1984");
    Book audiobook1 = new AudioBook("Dune");
 //   Book audiobook2 =  new AudioBook("1984");
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice", BorrowingService.getInstance()); // flush borrowedBook array
		member2 = new Member("Bob", BorrowingService.getInstance());   // flush borrowedBook array
		book1.setIsAvailable(true);
	//	book2.setIsAvailable(true);
        audiobook1.setIsAvailable(true);
     //   audiobook2.setIsAvailable(true);
	}
	@Test
	void tryToBorrowPaperBook() {
		
		// first member borrows a book
		
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed books should be zero");
		assertEquals(member2.borrowedBooksCount(), 0, "Borrowed books should be zero");
		
		assertTrue(book1.getIsAvailable(), "Book should be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(), "Book should be borrowed");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of borrowed books must be 1");
		
		// second member borrows the same book 
		member2.borrowBook(book1);
		assertFalse(book1.getIsAvailable(), "Book should still be borrowed" );
		assertEquals(member1.borrowedBooksCount(), 1, "Member should have one book");
		assertEquals(member2.borrowedBooksCount(), 0, "Member should have no books after rejection");
		
		// first member returns the book 
		member1.returnBook(book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		
		// second member borrows the same book 
		member2.borrowBook(book1);
		
		assertFalse(book1.getIsAvailable(), "Book should be borrowed");
		assertEquals(member1.borrowedBooksCount(), 0, "Member should have no borrowed books");
		assertEquals(member2.borrowedBooksCount(), 1, "Member should have one book");
		
			
	}

    @Test
    void tryToBorrowAudioBook() {

        // first member borrows a book

        assertEquals(member1.borrowedBooksCount(), 0, "Borrowed books should be zero");
        assertEquals(member2.borrowedBooksCount(), 0, "Borrowed books should be zero");

        assertTrue(audiobook1.getIsAvailable(), "Book should be available");
        member1.borrowBook(audiobook1);
        assertFalse(audiobook1.getIsAvailable(), "Book should be borrowed");
        assertEquals(member1.borrowedBooksCount(), 1, "Count of borrowed books must be 1");

        // second member borrows the same book
        member2.borrowBook(audiobook1);
        assertFalse(audiobook1.getIsAvailable(), "Book should still be borrowed" );
        assertEquals(member1.borrowedBooksCount(), 1, "Member should have one book");
        assertEquals(member2.borrowedBooksCount(), 0, "Member should have no books after rejection");

        // first member returns the book
        member1.returnBook(audiobook1);
        assertTrue(audiobook1.getIsAvailable(), "Book should be available after return");

        // second member borrows the same book
        member2.borrowBook(audiobook1);

        assertFalse(audiobook1.getIsAvailable(), "Book should be borrowed");
        assertEquals(member1.borrowedBooksCount(), 0, "Member should have no borrowed books");
        assertEquals(member2.borrowedBooksCount(), 1, "Member should have one book");


    }

}
