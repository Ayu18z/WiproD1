//Create a book class, write some attributes, static variable to be created is book count


package day4;

import java.util.Scanner;

public class BooksObj {
	
	static class Book{
		Scanner s = new Scanner (System.in);
		String title;
		int pages;
		int Cost;
		String produecer = "ABC";
	
		Book(String title, int pages, int cost){
			int BookCount = 0;
			this.title = title;
			this.pages = pages;
			this.Cost = Cost;
			BookCount++;
		}
		
		 void display() {
	            System.out.println("Title: " + title);
	            System.out.println("Pages: " + pages);
	            System.out.println("Cost: " + Cost);
	            System.out.println("Producer: " + produecer);
	            System.out.println("-----------------------");
	        }
		
		
	}
	
	
	public static void main(String[] args) {
		
	}

	
	
}
