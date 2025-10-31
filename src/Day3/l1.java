package Day3;
import java.util.*;

public class l1 {

    // --- Student class ---
    static class Student {
        private String name;
        private int rollNo;
        private double marks;

        // Default Constructor
        Student() {
            System.out.println("Default Constructor Called");
        }

        // Parameterized Constructor
        Student(String name, int rollNo, double marks) {
            this.name = name;
            this.rollNo = rollNo;
            this.marks = marks;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRollNo() {
            return rollNo;
        }

        public void setRollNo(int rollNo) {
            this.rollNo = rollNo;
        }

        public double getMarks() {
            return marks;
        }

        public void setMarks(double marks) {
            this.marks = marks;
        }

        // Display Info
        void displayInfo() {
            System.out.println("Name: " + name);
            System.out.println("Roll No: " + rollNo);
            System.out.println("Marks: " + marks);
            System.out.println("----------------------");
        }
    }

    // --- Main class functionality ---
    void menu() {
        System.out.println("Menu");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("0. Exit");
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        l1 obj = new l1();
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[10];
        int count = 0;
        int choice;

        do {
            obj.menu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count < students.length) {
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Roll No: ");
                        int rollNo = sc.nextInt();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        students[count] = new Student(name, rollNo, marks);
                        count++;
                        System.out.println("Student added successfully!\n");
                    } else {
                        System.out.println("Student list is full!\n");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No students to display.\n");
                    } else {
                        System.out.println("---- Student Details ----");
                        for (int i = 0; i < count; i++) {
                            students[i].displayInfo();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.\n");
            }

        } while (choice != 0);

        sc.close();
    }
}
