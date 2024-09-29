import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;
    private List<Student> students;
    public Library(String name){
        this.name = name;
        this.books = new ArrayList<Book>();
        this.students = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public List<Book> getBooks(){
        return books;
    }
    public List<Student> getStudents(){
        return students;
    }
}
