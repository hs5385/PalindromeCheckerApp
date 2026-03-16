public class PalindromeCheckerApp {
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        return checkRecursive(str, 0, str.length() - 1);
    }
    private boolean checkRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return checkRecursive(str, start + 1, end - 1);
    }
    public static void main(String[] args) {
        PalindromeCheckerApp checker = new PalindromeCheckerApp();
        String word = "racecar";
        boolean result = checker.isPalindrome(word);
        System.out.println("Is '" + word + "' a palindrome? " + result);
    }
}