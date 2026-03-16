public class PalindromeCheckerApp {
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        return checkLogic(normalized);
    }
    private boolean checkLogic(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromeCheckerApp checker = new PalindromeCheckerApp();
        String input = "A man a plan a canal Panama";
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + checker.isPalindrome(input));
    }
}