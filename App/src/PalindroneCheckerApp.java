//version 1.0
//author Abc
//useCase 1: Welcome page
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

                System.out.println("Enter a string(lower case):");
        s=sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        Deque<Character> deque = new ArrayDeque<>();

        // Push each character of the string into the stack
        for (char c : s.toCharArray()) {
            queue.add(c);
            stack.push(c);
            deque.addLast(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Iterate again through original string
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                while (deque.size() > 1) {
                    if (deque.removeFirst() != deque.removeLast()) {
                        isPalindrome = false;
                        break;
                    }
                }

                if(isPalindrome){
                    System.out.println("Palindrome");
                }
                else{
                    System.out.println("Is not a Palindrome");
                }
                sc.close();
            }
        }