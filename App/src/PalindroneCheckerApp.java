//version 1.0
//author Abc
//useCase 1: Welcome page

import java.util.Scanner;

public class PalindroneCheckerApp {

    // Method to check palindrome using two-pointer technique
    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Normalize string
        // Remove spaces using Regular Expression
        input = input.replaceAll("\\s+", "");

        // Convert to lowercase (case-insensitive comparison)
        input = input.toLowerCase();

        // Step 2: Apply palindrome logic
        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}