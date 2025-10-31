//# Student application
//1. Add ## done
//2. display ## done
//3. display one ## done
//4. delete (move each element up)
//5. Modify (make nested menu in which you should ask what needs to be modifies )
//6. sort as per the Marks

package Day3;
import java.util.*;

class main {
    private String studentName;
    private int studentId;
    private double studentMarks;

    // Getters and Setters
    private String getStudentName() {
        return studentName;
    }
    private void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getStudentId() {
        return studentId;
    }
    private void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    private double getStudentMarks() {
        return studentMarks;
    }
    private void setStudentMarks(double studentMarks) {
        this.studentMarks = studentMarks;
    }

    // Default Constructor
    main() {
        System.out.println("Default Constructor Called");
    }

    // Parameterized Constructor
    main(String studentName, int studentId, double studentMarks) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.setStudentMarks(studentMarks);
    }

    void showDetails() {
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentId);
        System.out.println("Marks: " + studentMarks);
    }
}

public class main {

    void showMenu() {
        System.out.println("Menu");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        Main app = new Main();
        main[] studentList = new main[3];
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            app.showMenu();
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    for (int i = 0; i < studentList.length; i++) {
                        if (studentList[i] == null) {
                            System.out.print("Enter Name: ");
                            String name = scanner.next();
                            System.out.print("Enter Roll No: ");
                            int id = scanner.nextInt();
                            System.out.print("Enter Marks: ");
                            double marks = scanner.nextDouble();
                            studentList[i] = new main(name, id, marks);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Student Details:");
                    for (main s : studentList) {
                        if (s != null) {
                            s.showDetails();
                            System.out.println("-----");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int findId = scanner.nextInt();
                    boolean found = false;
                    for (main s : studentList) {
                        if (s != null && s.getStudentId() == findId) {
                            s.showDetails();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (option != 0);

        scanner.close();
    }
}
