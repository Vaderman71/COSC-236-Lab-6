package lab5;

public class BorrowingService implements BorrowingServiceAPI {

	

    private static BorrowingService instance; // private member
    private int borrowingLimit; // to restrict the count of borrowed books
    private BorrowingService() { // private constructor
        borrowingLimit = 3;
    }
    public static BorrowingService getInstance( ) {
        if (instance == null) {
            instance = new BorrowingService();
        }
        return instance;
    }

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        if (book == null) {
            return new BorrowingBookResult(false, "Invalid book.");
        }
        if (member.hasBorrowed(book)) {
            return new BorrowingBookResult(false, "Member already borrowed this book.");
        }
        if (!book.getIsAvailable()) {
            return new BorrowingBookResult(false, "Book is currently unavailable.");
        }
        if (member.getBorrowedBooks().size() >= borrowingLimit) {
            return new BorrowingBookResult(false, "Borrowing limit exceeded. Max " + borrowingLimit + " books allowed.");
        }

        member.addBorrowedBook(book);
        book.setIsAvailable(false);
        return new BorrowingBookResult(true, "Book borrowed successfully.");
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        if (book == null) {
            return new BorrowingBookResult(false, "Invalid book.");
        }
        if (!member.hasBorrowed(book)) {
            return new BorrowingBookResult(false, "Book not found in member's borrowed list.");
        }
        if (book instanceof PaperBook && book.getIsAvailable()  || book instanceof AudioBook && book.getIsAvailable() ) {  // Only check for PaperBooks
            return new BorrowingBookResult(false, "Book has already been returned.");
        }

        member.removeBorrowedBook(book);
        book.setIsAvailable(true);
        return new BorrowingBookResult(true, "Book returned successfully.");
    }
}

