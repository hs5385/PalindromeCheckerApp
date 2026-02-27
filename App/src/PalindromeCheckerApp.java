import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String original = sc.next();
        String reverse = "";
        int l  = original.length();;
        for (int i = l - 1; i >= 0; i--) {
            reverse += original.charAt(i);
        }
        if (original.equalsIgnoreCase(reverse)) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }
    }
}