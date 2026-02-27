
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String original = "RACECAR";
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