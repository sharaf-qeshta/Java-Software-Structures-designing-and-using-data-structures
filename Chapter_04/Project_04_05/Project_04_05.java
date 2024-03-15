package chapter_04;

import java.util.Scanner;

/**
 * PP 4.5 Design and implement an application that reads a sentence from
 * the user and prints the sentence with the characters of each
 * word backward. Use a stack to reverse the characters of each
 * word.
 *
 * @author Sharaf Qeshta
 * */
public class Project_04_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String phrase = scanner.nextLine();
        String[] words = phrase.split(" ");
        for (String word: words)
        {
            LinkedStack<Character> stack = new LinkedStack<>();
            for (int i = 0; i < word.length(); i++)
                stack.push(word.charAt(i));
            System.out.print(stack.toString2()+ " ");
        }
    }
}
