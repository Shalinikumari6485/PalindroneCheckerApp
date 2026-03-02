import java.util.Scanner;
public class PalindroneCheckerApp {
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
        input = input.replaceAll("\\s+", "");
        input = input.toLowerCase();
        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
        scanner.close();
    }
}
