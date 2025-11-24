package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

    private String name;
    private ArrayList<Book> borrowedItems;
    private BorrowingService borrowingService; // Injected via constructor
    // Constructor now takes the Singleton BorrowingService instance
    public Member(String name, BorrowingService service) {
        this.name = name;
        this.borrowedItems = new ArrayList<>();
        this.borrowingService = service; // Store the Singleton instance
    }


    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member: " + name;
    }

    public boolean hasBorrowed(Book book) {
        return borrowedItems.contains(book);
    }

    public void addBorrowedBook(Book book) {
        borrowedItems.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedItems.remove(book);
    }

    public void borrowBook(Book book) {
        BorrowingService borrowingService = BorrowingService.getInstance();
        BorrowingBookResult result = borrowingService.borrowBook(this, book);
        System.out.println("Success: " + result.isSuccess() + " | " + result.getBorrowingMessage());
    }

    public void returnBook(Book book) {
        BorrowingServiceAPI borrowingService = BorrowingService.getInstance();
        BorrowingBookResult result = borrowingService.returnBook(this, book);
        System.out.println("Success: " + result.isSuccess() + " | " + result.getBorrowingMessage());
    }

    public void listBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : borrowedItems) {
            System.out.println(book);
        }
    }

    public int borrowedBooksCount() {
        return borrowedItems.size();
    }

    public void returnAllBooks() {
        for (Book book : borrowedItems) {
            returnBook(book);
        }
        borrowedItems.clear();
    }

    public Object getBorrowingService() {
        return null;
    }
}