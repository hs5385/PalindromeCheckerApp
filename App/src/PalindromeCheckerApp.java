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

public class PalindromeCheckerApp {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void comparePerformance(String input) {
        if (input == null || strategy == null) return;

        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        long startTime = System.nanoTime();
        boolean result = strategy.isPalindrome(cleanInput);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Strategy: " + strategy.getClass().getSimpleName());
        System.out.println("Result: " + result);
        System.out.println("Execution Time: " + duration + " ns");
        System.out.println("---");
    }

    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();

        // Repeating the string to create a significant workload for benchmarking
        String testInput = "A man, a plan, a canal: Panama".repeat(100);

        System.out.println("UC13: Performance Comparison");
        System.out.println("Testing input length: " + testInput.length() + " characters");
        System.out.println("==========================================");

        app.setStrategy(new StackStrategy());
        app.comparePerformance(testInput);

        app.setStrategy(new DequeStrategy());
        app.comparePerformance(testInput);
    }
}