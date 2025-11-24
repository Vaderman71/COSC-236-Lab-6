package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

    private String name;
    private ArrayList<Book> borrowedBooks; // Book class dependency

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member: " + name;
    }

    public boolean hasBorrowed(Book book) {
        return borrowedBooks.contains(book);
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void borrowBook(Book book) {
        BorrowingService borrowingService = new BorrowingService();
        BorrowingBookResult result = borrowingService.borrowBook(this, book);
        System.out.println("Success: " + result.isSuccess() + " | " + result.getBorrowingMessage());
    }

    public void returnBook(Book book) {
        BorrowingServiceAPI borrowingService = new BorrowingService();
        BorrowingBookResult result = borrowingService.returnBook(this, book);
        System.out.println("Success: " + result.isSuccess() + " | " + result.getBorrowingMessage());
    }

    public void listBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

    public int borrowedBooksCount() {
        return borrowedBooks.size();
    }

    public void returnAllBooks() {
        Iterator<Book> bookIterator = borrowedBooks.iterator();
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            returnBook(book);
        }
        borrowedBooks.clear();
    }

    public Object getBorrowingService() {
        return null;
    }
}