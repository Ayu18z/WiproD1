package Day3;

public class fCode {

    static class Book {
        String title = "Unknown";
        String author = "ABC";
        double price = 500.00;

        Book() {
            System.out.println("Default Constructor Called");
        }

        Book(double price) {
            this("check", "check");
            this.price = price;
        }

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        void displayInfo() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: $" + price);
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book();               // calls default constructor
        Book book2 = new Book("Aaa", "bbb");   // calls 2-arg constructor
        Book book3 = new Book(999.99);         // calls 1-arg constructor

        System.out.println("----Book 2 Info----");
        book2.displayInfo();

        System.out.println("----Book 3 Info----");
        book3.displayInfo();
    }
}
