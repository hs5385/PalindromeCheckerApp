import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        int len = text.length();
        for (int i = 0; i < len / 2; i++) {
            stack.push(text.charAt(i));
        }
        int start = (len % 2 == 0) ? len / 2 : (len / 2) + 1;
        for (int i = start; i < len; i++) {
            if (stack.isEmpty() || text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
class PalindromCheckerApp {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean checkPalindrome(String input) {
        if (input == null || strategy == null) return false;
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return strategy.isPalindrome(cleanInput);
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromCheckerApp service = new PalindromCheckerApp();
        String test = "A man, a plan, a canal: Panama";
        System.out.println("Testing Strategy Pattern for: " + test);
        System.out.println("---");
        service.setStrategy(new StackStrategy());
        System.out.println("Using StackStrategy: " + service.checkPalindrome(test));
        service.setStrategy(new DequeStrategy());
        System.out.println("Using DequeStrategy: " + service.checkPalindrome(test));
    }
}