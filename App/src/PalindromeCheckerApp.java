
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "racecar";
        char[] charArray = input.toCharArray();
        boolean isMatch = compareEdges(charArray);
        System.out.println("Do the start and end characters match? " + isMatch);
    }
    public static boolean compareEdges(char[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr.length == 0) return false;
        System.out.println("Comparing: " + arr[start] + " and " + arr[end]);
        return arr[start] == arr[end];
    }
}