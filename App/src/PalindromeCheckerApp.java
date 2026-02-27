import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "madam";
        boolean result = isPalindrome(input);
        System.out.println("Is '" + input + "' a palindrome? " + result);
    }
    public static boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) {
            char originalChar = text.charAt(i);
            char reversedChar = stack.pop();
            if (originalChar != reversedChar) {
                return false;
            }
        }
        return true;
    }
}