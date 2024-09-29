public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    private int quantity;

    public Book(String title, String author, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
        this.available = true;
    }
    public String getTitle() {
        return title;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setAvailable() {
            this.available = this.quantity != 0;
    }
    public void borrow(){
        this.quantity--;
    }
    public void returnBook(){
        this.quantity++;
        this.setAvailable();
    }
    public boolean isAvailable() {
        return this.available;
    }
}
