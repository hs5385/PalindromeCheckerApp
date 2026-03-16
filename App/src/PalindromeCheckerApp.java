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

    public void comparePerformance(String input) {
        if (input == null || strategy == null) return;

        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Capture start time
        long startTime = System.nanoTime();

        boolean result = strategy.isPalindrome(cleanInput);

        // Capture end time
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Strategy: " + strategy.getClass().getSimpleName());
        System.out.println("Result: " + result);
        System.out.println("Execution Time: " + duration + " nanoseconds");
        System.out.println("---");
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromCheckerApp service = new PalindromCheckerApp();

        // Using a longer string to make the performance difference more noticeable
        String test = "Madam, in Eden, I'm Adam. ".repeat(100);

        System.out.println("Performance Comparison (UC13)");
        System.out.println("==============================");

        service.setStrategy(new StackStrategy());
        service.comparePerformance(test);

        service.setStrategy(new DequeStrategy());
        service.comparePerformance(test);
    }
}