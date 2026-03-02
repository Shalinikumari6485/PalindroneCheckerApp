//version 1.0
//author Abc
//useCase 1: Welcome page

import java.util.Stack;

public class PalindroneCheckerApp {

    // Encapsulated method
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize input (ignore spaces & case)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare original string with stack (reverse order)
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
