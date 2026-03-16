class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
public class PalindromeCheckerApp {
    public boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;
        Node head = convertToLinkedList(str);
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;
        Node temp = secondHalf;
        boolean result = true;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        reverseList(secondHalf);
        return result;
    }
    private Node convertToLinkedList(String str) {
        Node head = new Node(str.charAt(0));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    public static void main(String[] args) {
        PalindromeCheckerApp checker = new PalindromeCheckerApp();
        String input = "racecar";
        System.out.println("Is \"" + input + "\" a palindrome? " + checker.isPalindrome(input));
    }
}