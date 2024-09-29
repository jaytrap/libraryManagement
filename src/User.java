import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;
    public User(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }
}
