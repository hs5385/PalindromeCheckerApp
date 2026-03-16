import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = scanner.nextLine();
        if (isPalindromeDeque(input)) {
            System.out.println("Result: Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }
        scanner.close();
    }
    public static boolean isPalindromeDeque(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (cleanText.isEmpty()) return true;
        Deque<Character> charDeque = new ArrayDeque<>();
        for (char ch : cleanText.toCharArray()) {
            charDeque.addLast(ch);
        }
        while (charDeque.size() > 1) {
            Character front = charDeque.removeFirst();
            Character rear = charDeque.removeLast();
            if (!front.equals(rear)) {
                return false;
            }
        }
        return true;
    }
}