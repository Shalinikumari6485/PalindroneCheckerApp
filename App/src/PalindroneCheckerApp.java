//version 1.0
//author Abc
//useCase 1: Welcome page

import java.util.*;

public class PalindroneCheckerApp {

    // Two Pointer Approach
    public static boolean twoPointerCheck(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    //Stack Approach

    public static boolean stackCheck(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    //Deque Approach

    public static boolean dequeCheck(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    // Recursive Approach

    public static boolean recursiveCheck(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return recursiveHelper(normalized, 0, normalized.length() - 1);
    }

    private static boolean recursiveHelper(String str, int start, int end) {

        if (start >= end) return true;

        if (str.charAt(start) != str.charAt(end)) return false;

        return recursiveHelper(str, start + 1, end - 1);
    }

    // Main Method

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        //Two Pointer
        long startTime = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        //Stack
        startTime = System.nanoTime();
        boolean result2 = stackCheck(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        //Deque
        startTime = System.nanoTime();
        boolean result3 = dequeCheck(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        //Recursion
        startTime = System.nanoTime();
        boolean result4 = recursiveCheck(input);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        System.out.println("\n PERFORMANCE RESULTS (nanoseconds)");

        System.out.println("Two Pointer  : " + twoPointerTime + " ns | Result: " + result1);
        System.out.println("Stack        : " + stackTime + " ns | Result: " + result2);
        System.out.println("Deque        : " + dequeTime + " ns | Result: " + result3);
        System.out.println("Recursive    : " + recursiveTime + " ns | Result: " + result4);

        scanner.close();
    }
}