package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.Book;
import lab5.Member;
import lab5.PaperBook;



class TestAddRemoveBooks {
	
	private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}

	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	Book book3 = new PaperBook("Moby Dick");

//    Book ebook1 = new EBook("Dune");
//    Book ebook2 = new EBook("1984");
//    Book ebook3 = new EBook("Moby Dick");
//
//    Book audiobook1 = new AudioBook("Dune");
//    Book audiobook2 = new AudioBook("1984");
//    Book audiobook3 = new AudioBook("Moby Dick");
	
	Member member = new Member("Grady Booch");

    //could change this to mix media :
	@Test
	void AddBooks() {
		
		assertEquals(library.booksCount(), 0, "Should be no books in library");	
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
	}

//    @Test
//    void AddPaperBooks() {
//
//        assertEquals(library.booksCount(), 0, "Should be no books in library");
//        library.addPaperBook(book1);
//        library.addPaperBook(book2);
//        library.addpaperBook(book3);
//        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
//    }

//    @Test
//    void AddEBooks() {
//
//        assertEquals(library.booksCount(), 0, "Should be no books in library");
//        library.addEBook(ebook1);
//        library.addEBook(ebook2);
//        library.addEBook(ebook3);
//        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
//    }

//    @Test
//    void AddAudioBooks() {
//
//        assertEquals(library.booksCount(), 0, "Should be no books in library");
//        library.addAudioBook(audiobook1);
//        library.addAudioBook(audiobook2);
//        library.addAudioBook(audiobook3);
//        assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
//    }
	
	@Test
	void RemoveBooksBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		library.removeBook(book2);
		library.removeBook(book3);
		assertEquals(library.booksCount(), 1, "There should be only one book left in the library");
	}
	
	@Test
	void RemoveBooksString() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		library.removeBook("Dune");
		assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
	}
	
	@Test
	void RemoveBorrowedBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		
		member.borrowBook(book1);
		assertEquals(member.borrowedBooksCount(), 1, "Should be 1 borrowed book");
		
		library.removeBook(book1);
		assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
		
		assertEquals(member.borrowedBooksCount(), 1, "The book should stay with member"); // 
		
		Book b = member.getBorrowedBooks().get(0); // the only book
		assertEquals(b, book1,"The owned book should be the removed book");
	}
	
	
}
