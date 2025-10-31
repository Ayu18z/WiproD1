package Day3;
import java.util.*;

class Student {
    private String name;
    private int rollNo;
    private double marks;

    Student() {    
        System.out.println("Default Constructor Called");
    }

    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getMarks() {
        return marks;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }
}

public class StudentData {

    void menu() {
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Display ONE Student");
        System.out.println("4. Delete By Roll No");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        StudentData app = new StudentData();
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();  // ✅ dynamic list
        int choice;

        do {
            app.menu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: // ADD STUDENT
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    students.add(new Student(name, roll, marks));
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2: // DISPLAY ALL
                    if (students.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            s.displayInfo();
                            System.out.println("---------------");
                        }
                    }
                    break;

                case 3: // DISPLAY ONE
                    System.out.print("Enter Roll No to search: ");
                    int searchRoll = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getRollNo() == searchRoll) {
                            s.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Student not found!");
                    break;

                case 4: // DELETE BY ROLL
                    System.out.print("Enter Roll No to delete: ");
                    int deleteRoll = sc.nextInt();
                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getRollNo() == deleteRoll) {
                            students.remove(i);
                            deleted = true;
                            System.out.println("Student record deleted successfully!");
                            break;
                        }
                    }
                    if (!deleted)
                        System.out.println("Student with Roll No " + deleteRoll + " not found.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
