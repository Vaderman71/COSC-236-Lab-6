package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    private static BorrowingService instance; // private member
    private int borrowingLimit; // to restrict the count of borrowed books
    private BorrowingService() { // private constructor
        borrowingLimit = 3;
    }
    public static BorrowingService getInstance( ) {
    // TODO
    // Implement Singleton pattern. return instance;
        if (instance == null) {
            instance = new BorrowingService();
        }
        return instance;
    }
    // The rest of code ...
    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {

    }
    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {

    }
}
