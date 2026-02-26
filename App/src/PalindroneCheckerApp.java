//version 1.0
//author Abc
//useCase 1: Welcome page
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

                System.out.println("Enter a string(lower case):");
        s=sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Push each character of the string into the stack
        for (char c : s.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Iterate again through original string
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) {
                while (!queue.isEmpty()) {
                    if (queue.remove() != stack.pop()) {
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