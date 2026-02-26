//version 1.0
//author Abc
//useCase 1: Welcome page
import java.util.Scanner;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
                System.out.println("Enter a string(lower case):");
        s=sc.nextLine();

        char [] chars= s.toCharArray();
        Stack<Character> stack = new Stack<>();

        int start =0;
        int end=chars.length - 1;
        // Push each character of the string into the stack
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome=true;

        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {

                for (char c : s.toCharArray()) {
                    if (c != stack.pop()) {
                        isPalindrome = false;
                        break;
                    }
                    start++;
                    end--;
                }

                if (isPalindrome) {
                    System.out.println("Palindrome");
                } else {
                    System.out.println("Is not a Palindrome");
                }
                sc.close();
            }
        }