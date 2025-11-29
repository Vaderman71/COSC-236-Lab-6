package tests;


import lab5.Library;
import lab5.Book;
import lab5.PaperBook;
import lab5.EBook;
import lab5.AudioBook;
import lab5.BookFactory;
import lab5.PaperBookFactory;
import lab5.EBookFactory;
import lab5.AudioBookFactory;
import lab5.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


/*
*
6. Write test cases to verify that the Factory Method correctly creates
  the appropriate type of Book objects.
Ensure the tests cover the following scenarios:
 * The factory correctly creates instances of different types of books.

 *The created objects are of the expected type (i.e., the right subclass of Book).
*   Include tests for edge cases, such as
trying to create unsupported book types.
* */


public class TestFactoryMethodPattern {

    private Library library;

    @BeforeEach
    void setUp() throws Exception {
        this.library = new Library(); // empty library for each test
    }
    Book book = new PaperBook("Dune");
    Book eBook = new EBook("Dune");
    Book audioBook = new AudioBook("Dune");
    BookFactory paperBookFactory = new PaperBookFactory();
    BookFactory eBookFactory = new EBookFactory();
    BookFactory audioBookFactory = new AudioBookFactory();


    @Test
    void createInstancesOfBooks(){
        assertEquals(book, paperBookFactory.createBook('Dune'));
        assertEquals(eBook, eBookFactory.createBook('Dune'););
        assertEquals(audioBook, audioBookFactory.createBook('Dune'));
    }

    @Test
    void createInstancesOfUnsupportedBooks(){
        assertNotEquals(audioBook, paperBookFactory.createBook('Dune'));
        assertNotEquals(book, eBookFactory.createBook('Dune'));
        assertNotEquals(book, audioBookFactory.createBook('Dune'));
    }

}
