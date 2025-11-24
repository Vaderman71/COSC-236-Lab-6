
public class BorrowingService implements BorrowingServiceAPI {

	
    private static final int BORROW_LIMIT = 3;

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
        if (member.getBorrowedBooks().size() >= BORROW_LIMIT) {
            return new BorrowingBookResult(false, "Borrowing limit exceeded. Max " + BORROW_LIMIT + " books allowed.");
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
        if (book.getIsAvailable()) {
            return new BorrowingBookResult(false, "Book has already been returned.");
        }

        member.removeBorrowedBook(book);
        book.setIsAvailable(true);
        return new BorrowingBookResult(true, "Book returned successfully.");
    }
}

