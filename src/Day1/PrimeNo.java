package Day1;
import java.util.Scanner;

public class PrimeNo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int temp = num, rev = 0;

        while (num != 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }

        if (temp == rev)
            System.out.println(temp + " is a palindrome number.");
        else
            System.out.println(temp + " is not a palindrome number.");
        
        sc.close();
    }
}
