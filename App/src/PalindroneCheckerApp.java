import java.util.Stack;
public class PalindroneCheckerApp {
    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
