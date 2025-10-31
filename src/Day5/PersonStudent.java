package Day5;

import java.util.ArrayList;

public class PersonStudent {

	
	    static class Person {
	        String name;

	        Person(String name) {
	            this.name = name;
	        }

	        void displayInfo() {
	            System.out.println("Name: " + name);
	        }
	    }

	    static class Student extends Person {
	        int rollNumber;

	        Student(String name, int rollNumber) {
	            super(name); // calls parent class constructor
	            this.rollNumber = rollNumber;
	        }

	        @Override
	        void displayInfo() {
	            super.displayInfo(); // calls Person's displayInfo()
	            System.out.println("Roll Number: " + rollNumber);
	        }
	    }

	    public static void main(String[] args) {
	        Student s1 = new Student("Ayush", 45);
	        s1.displayInfo();
	        
	        
	    }
	}

	
