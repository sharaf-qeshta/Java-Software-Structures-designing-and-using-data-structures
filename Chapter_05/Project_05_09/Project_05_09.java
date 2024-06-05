package chapter_05;

/**
 * PP 5.9 Create a system using a stack and a queue to test whether a given
 * string is a palindrome (that is, whether the characters read the
 * same both forward and backward).
 *
 * @author Sharaf Qeshta
 * */
public class Project_05_09
{
    public static void main(String[] args)
    {
        System.out.println(isPalindrome("sharaf")); // false
        System.out.println(isPalindrome("madam")); // true
        System.out.println(isPalindrome("kayak")); // true
        System.out.println(isPalindrome("keshta")); // false
        System.out.println(isPalindrome("noon")); // true
    }
    public static boolean isPalindrome(String string)
    {
        LinkedDeque<Character> deque = new LinkedDeque<>();
        for (int i = 0; i < string.length(); i++)
            deque.pushFront(string.charAt(i));
        return deque.forward().equals(deque.backward());
    }
}
