import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printOnScreen("Welcome to your library app !");
        printOnScreen("Enter your library name .. : ");
        String name  = new Scanner(System.in).nextLine();
        Library library = new Library(name);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a Book");
            System.out.println("2. List Available Books");
            System.out.println("3. Add a Student");
            System.out.println("4. List Students");
            System.out.println("5. Library Details");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    listAvailableBooks(library);
                    break;
                case 3:
                    addStudent(library,scanner);
                    break;
                case 4:
                    listStudents(library);
                    break;
                case 5:
                    libraryDetails(library);
                    return;
                case 6:
                    studentBorrowBook(library, scanner);
                    break;
                case 7:
                    studentReturnBook(library, scanner);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void libraryDetails(Library library) {
        System.out.println("Library Details:");
        System.out.println("Name: "+ library.getName());
        System.out.println("Number of books "+ library.getBooks().size());
        System.out.println("Number of students "+ library.getStudents().size());

    }

    private static void studentReturnBook(Library library, Scanner scanner) {
        System.out.println("Enter student name");
        Student student = getStudent(library, scanner);
        System.out.println("Enter book title");
        Book book = getBook(library, scanner);
        for (Book book1: student.getBorrowedBooks()){
            if(book1.getTitle().equals(book.getTitle())){
                book.returnBook();
                student.removeBorrowedBook(book);
            }
        }
        System.out.println("Book returned!");
    }

    private static void studentBorrowBook(Library library, Scanner scanner) {
        System.out.println("Enter student name");
        Student student = getStudent(library, scanner);
        System.out.println("Enter book title");
        Book book = getBook(library, scanner);
        if(book.isAvailable()){
            System.out.println("Book is available!");
            student.addBorrowedBook(book);
            System.out.println("Book borrowed!");
            book.borrow();
        }else {
            System.out.println("Sorry this book is not available!");
        }

    }

    private static Book getBook(Library library, Scanner scanner) {
        String title = scanner.nextLine();
        while (getBookByName(title, library) == null) {
            System.out.println("Invalid book title. Please try again.");
            title = scanner.nextLine();
        }
        return getBookByName(title, library);
    }

    private static Student getStudent(Library library, Scanner scanner) {
        String name = scanner.nextLine();
        while (getStudentByName(name, library) == null) {
            System.out.println("Invalid student name. Please try again.");
            name = scanner.nextLine();
        }
        return getStudentByName(name, library);
    }

    private static void listStudents(Library library) {
        List<Student> students = library.getStudents();
        if (students.isEmpty()) {
            System.out.println("There are no students in the library");
        }else {
            System.out.printf("%-20s %10s %20s%n", "Student Name", "Class", "Books Borrowed");
            for (Student student : students) {
                System.out.printf("%-20s %10s %20d%n",student.getName(), student.getClassName(), student.getBorrowedBooks().size());
            }
        }
    }

    private static void addStudent(Library library, Scanner scanner) {
        System.out.println("Enter student name");
        String name = scanner.nextLine();
        System.out.println("Enter student id number");
        String idNumber = scanner.nextLine();
        System.out.println("Enter class name");
        String className = scanner.nextLine();
        Student student = new Student(name, idNumber, className);
        library.addStudent(student);
        System.out.println("Student added!");

    }

    private static void listAvailableBooks(Library library) {
        List<Book> books = library.getBooks();
        if (books.isEmpty()) {
            System.out.println("There are no books available");
        }else {
            System.out.printf("%-20s %10s%n", "Book Name", "Quantity");
            for (Book book : books) {
                if (book.isAvailable()) {
                    System.out.printf("%-20s %10s%n", book.getTitle(), book.getQuantity());
                }
            }
        }
    }

    static void addBook(Library library, Scanner scanner) {
        System.out.println("Enter book title");
        String title = scanner.nextLine();
        System.out.println("Enter book author");
        String author = scanner.nextLine();
        System.out.println("Enter book isbn");
        String isbn = scanner.nextLine();
        System.out.println("Enter book quantity");
        int quantity = scanner.nextInt();
        Book book = new Book(title, author, isbn, quantity);
        library.addBook(book);
        System.out.println("Book added!");
    }

    public static Student getStudentByName(String name, Library library){
        try {
            List<Student> students = library.getStudents();
            for (Student student : students) {
                if (student.getName().equals(name)) {
                    return student;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Book getBookByName(String name, Library library){
        try {
            List<Book> books = library.getBooks();
            for (Book book : books) {
                if (book.getTitle().equals(name)) {
                    return book;
                }
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static void printOnScreen(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }        }
        System.out.println();
        for (int i = 0; i < text.length()/2; i++) {
            System.out.print("--");
        }

        System.out.println();System.out.println();
    }
}