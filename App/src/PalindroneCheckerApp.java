//version 1.0
//author Abc
//useCase 1: Welcome page

import java.util.Scanner;

// Node class for the Singly Linked List
class Node {
    char data;
    Node next;

    Node(char d) {
        data = d;
        next = null;
    }
}

// Class to manage the Linked List and the Palindrome check logic
public class PalindroneCheckerApp {
    Node head;

    // Method to insert a new character at the end of the list
    public void insert(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Method to check if the linked list is a palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true; // Empty or single-node lists are palindromes
        }

        // 1. Find the middle of the linked list using fast and slow pointers
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 'slow' now points to the end of the first half

        // 2. Reverse the second half of the list starting from the node after 'slow'
        Node secondHalfHead = reverseList(slow.next);
        slow.next = secondHalfHead; // Optional: Link the first and reversed second half (can be useful for restoration)

        // 3. Compare both halves
        Node firstHalfPtr = head;
        Node secondHalfPtr = secondHalfHead;
        boolean isPal = true;
        while (secondHalfPtr != null) {
            if (firstHalfPtr.data != secondHalfPtr.data) {
                isPal = false;
                break;
            }
            firstHalfPtr = firstHalfPtr.next;
            secondHalfPtr = secondHalfPtr.next;
        }

        // Optional: Restore the original list structure (reverse the second half back)
        slow.next = reverseList(secondHalfHead);

        return isPal;
    }

    // Helper method to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev; // 'prev' is the new head of the reversed list
    }

    // Method to convert a string to a linked list
    public void convertStringToLinkedList(String str) {
        head = null; // Clear any existing list
        // Normalize the string (ignore spaces, punctuation, and case as per typical palindrome rules)
        String normalizedStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        for (char c : normalizedStr.toCharArray()) {
            insert(c);
        }
    }

    // Main method for console interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindroneCheckerApp checker = new PalindroneCheckerApp();

        System.out.println("Palindrome Checker App (UC8: Linked List Based)");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        checker.convertStringToLinkedList(input);

        if (checker.isPalindrome()) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }
}
