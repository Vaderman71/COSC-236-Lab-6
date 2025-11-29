package tests;

import lab5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestBorrowingService {


    private Library library;

    @BeforeEach
    void setUp() throws Exception {
        this.library = new Library(); // empty library for each test
    }
    BorrowingService borrowingService = BorrowingService.getInstance();

    Book book1 = new PaperBook("Dune");
    Book book2 = new PaperBook("1984");
    Book book3 = new PaperBook("The Hobbit");
    Book book4 = new PaperBook("Fox's Book of Martyrs");
    Member dude = new Member("Dude", borrowingService);

    @Test
    void testBorrowingLimit(){
        dude.borrowBook(book1);
        dude.borrowBook(book2);
        dude.borrowBook(book3);
        assertEquals(3, dude.borrowedBooksCount(), "Count of books should be 3");
        dude.borrowBook(book4);
        assertEquals(3, dude.borrowedBooksCount(), "Count of books should still be 3 because of limit");
    }

    @Test
    void testBorrowingLimitWithReturns(){
        dude.borrowBook(book1);
        dude.borrowBook(book2);
        dude.borrowBook(book3);
        assertEquals(3, dude.borrowedBooksCount(), "Count of books should be 3");
        dude.returnBook(book1);
        dude.borrowBook(book4);
        assertEquals(3, dude.borrowedBooksCount(), "Count of books should 3 because of return");
        dude.borrowBook(book1);
        assertNotEquals(4, dude.borrowedBooksCount(), "Count of books should NOT be 4 due to limit");
    }
}
