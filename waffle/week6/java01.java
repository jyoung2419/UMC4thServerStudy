// Student 클래스
public class Student {
    String name;
    int studentID;
    String major;

    public Student(String name, int studentID, String major) {
        this.name = name;
        this.studentID = studentID;
        this.major = major;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
        System.out.println("Major: " + major);
    }
}
// main 클래스
public class Main {
    public static void main(String[] args) {
        Student student = new Student("정진영", 202136035, "컴퓨터공학과");
        student.printInfo();
    }
}