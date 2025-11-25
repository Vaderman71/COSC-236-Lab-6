package tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.PaperBook;

class TestBorrowBooks {

	Member member1;
	Member member2;
	
	Book book1;
	Book book2;
    Book ebook1;
    Book ebook2;
    Book audiobook1;
    Book audiobook2;

	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice", BorrowingService.getInstance()); // flush borrowedBook array
		member2 = new Member("Bob", BorrowingService.getInstance());   // flush borrowedBook array
        book1 = new PaperBook("Dune");
        book2 = new PaperBook("1984");
        ebook1 = new EBook("Dune");
        ebook2 = new EBook("1984");
        audiobook1 = new AudioBook("Dune");
        audiobook2 = new AudioBook("1984");
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
        audiobook1.setIsAvailable(true);
        audiobook2.setIsAvailable(true);
	}
	@Test
	void borrowPaperBook() {
		
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
	void returnPaperBook() {
		
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


    @Test
    void borrowEBook() {

        // borrow first book
        assertEquals(0, member1.borrowedBooksCount(), "Borrowed book should be zero");
        assertTrue(ebook1.getIsAvailable(), "Book 1 must be available");
        member1.borrowBook(ebook1);
        assertTrue(ebook1.getIsAvailable(),"Book 1 must be available");
        assertEquals(1, member1.borrowedBooksCount(), "Count of borrowed books must be 1");

        // borrow second book
        assertTrue(ebook2.getIsAvailable(),"Book must be available");
        member1.borrowBook(ebook2);
        assertTrue(ebook1.getIsAvailable(), "Book should be available");
        assertEquals(2, member1.borrowedBooksCount(), "The book coubnt shoud be 2");
    }

    @Test
    void returnEBook() {

        // borrow two books
        assertTrue(ebook1.getIsAvailable(), "Book 1 should be available");
        assertTrue(ebook2.getIsAvailable(), "Book 2 should be available");
        assertEquals(0, member1.borrowedBooksCount(),"Member1 should not have any books" );
        member1.borrowBook(ebook1);
        member1.borrowBook(ebook2);
        assertEquals(2, member1.borrowedBooksCount(), "The count of books must be 2");
        assertTrue(ebook1.getIsAvailable(), "Book 1 should be available");
        assertTrue(ebook2.getIsAvailable(), "Book 2 should be available");

        // return first book
        member1.returnBook(ebook1);
        assertTrue(ebook1.getIsAvailable(), "Book should be available after return");
        assertEquals(1, member1.borrowedBooksCount(), "Count of books must be 1");
        // return second book
        member1.returnBook(ebook2);
        assertTrue(ebook2.getIsAvailable(), "Book should be available after return");
        assertEquals(0, member1.borrowedBooksCount(), "Member 1 should have no books");

    }

    @Test
    void borrowAudioBook() {

        // borrow first book
        assertEquals(0, member1.borrowedBooksCount(), "Borrowed book should be zero");
        assertTrue(audiobook1.getIsAvailable(), "Book 1 must be available");
        member1.borrowBook(audiobook1);
        assertFalse(audiobook1.getIsAvailable(),"Book 1 must be not available");
        assertEquals(1, member1.borrowedBooksCount(), "Count of borrowed books must be 1");

        // borrow second book
        assertTrue(audiobook2.getIsAvailable(),"Book must be available");
        member1.borrowBook(audiobook2);
        assertFalse(audiobook1.getIsAvailable(), "Book should not be available");
        assertEquals(2, member1.borrowedBooksCount(), "The book coubnt shoud be 2");
    }

    @Test
    void returnAudioBook() {

        // borrow two books
        assertTrue(audiobook1.getIsAvailable(), "Book 1 should be available");
        assertTrue(audiobook2.getIsAvailable(), "Book 2 should be available");
        assertEquals(0, member1.borrowedBooksCount(),"Member1 should not have any books" );
        member1.borrowBook(audiobook1);
        member1.borrowBook(audiobook2);
        assertEquals(2, member1.borrowedBooksCount(), "The count of books must be 2");
        assertFalse(audiobook1.getIsAvailable(), "Book 1 should not be available");
        assertFalse(audiobook2.getIsAvailable(), "Book 2 should not be available");

        // return first book
        member1.returnBook(audiobook1);
        assertTrue(audiobook1.getIsAvailable(), "Book should be available after return");
        assertEquals(1, member1.borrowedBooksCount(), "Count of books must be 1");
        // return second book
        member1.returnBook(audiobook2);
        assertTrue(audiobook2.getIsAvailable(), "Book should be available after return");
        assertEquals(0, member1.borrowedBooksCount(), "Member 1 should have no books");

    }

}
