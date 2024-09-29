public class Student extends User{
    private String studentId;
    private String className;

    public Student(String name, String studentId, String className) {
        super(name);
        this.studentId = studentId;
        this.className = className;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getClassName() {
        return className;
    }
}
