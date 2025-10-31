package Day1;

import java.util.Scanner;

public class Day2Leapyear {
	
public static void main(String[] args) {
	

	Scanner sc = new Scanner(System.in);
	int year = sc.nextInt();
	
	if(year%4 == 0 && year%100!= 0) {
		System.out.println("its a leap year");
		
	}else{
	System.out.println("its not a leap year");
	}
		
		
}
}
//Write a Java program to check whether a year is a leap year or not.
