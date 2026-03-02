import java.util.*;
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
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
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
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
}

class PalindromeContext {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean execute(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.checkPalindrome(input);
    }
}

public class PalindroneCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();
        System.out.println("Choose Palindrome Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else if (choice == 2) {
            context.setStrategy(new DequeStrategy());
        } else {
            System.out.println("Invalid choice! Defaulting to Stack Strategy.");
            context.setStrategy(new StackStrategy());
        }
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        boolean result = context.execute(input);
        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
