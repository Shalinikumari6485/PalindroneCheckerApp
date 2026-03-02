//version 1.0
//author Abc
//useCase 1: Welcome page

import java.util.Scanner;

public class PalindroneCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base Condition 1: If start >= end, all characters matched
        if (start >= end) {
            return true;
        }

        // If characters at current positions don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for remaining substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional: Normalize string (remove spaces & ignore case)
        input = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}