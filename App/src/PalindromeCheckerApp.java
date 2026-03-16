import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        String[] testCases = {"Level", "Hello", "A man, a plan, a canal: Panama", "12321"};
        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("Is Palindrome: " + app.checkPalindrome(test));
            System.out.println("---");
        }
    }
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
        String cleanInput = preprocess(input);
        return compareUsingStack(cleanInput);
    }
    private String preprocess(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
    private boolean compareUsingStack(String text) {
        Stack<Character> stack = new Stack<>();
        int len = text.length();
        for (int i = 0; i < len / 2; i++) {
            stack.push(text.charAt(i));
        }
        int startOfSecondHalf = (len % 2 == 0) ? len / 2 : (len / 2) + 1;
        for (int i = startOfSecondHalf; i < len; i++) {
            if (stack.isEmpty() || text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}