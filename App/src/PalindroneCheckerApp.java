//version 1.0
//author Abc
//useCase 1: Welcome page
public class PalindroneCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to Palindrone Checker App Management System");
        System.out.println("Modify this logic to usecase 2");
        System.out.println("Enter a string(lower case):");
        String sc = sc.nextLine();
        boolean isPalindrome = true;

        for (int i = 0; i < sc.length() / 2; i++) {
            if (sc.charAt(i) != sc.charAt(sc.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if(s.equals(text)){
            if(isPalindrome){
                System.out.println("Palindrome");
            }
            else{
                System.out.println("Is not a Palindrome");
            }
            sc.close();
        }
    }
            }