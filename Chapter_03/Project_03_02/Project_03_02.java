package chapter_01;

import java.util.Scanner;

/**
 * PP 3.2 Design and implement an application that reads a sentence from
 * the user and prints the sentence with the characters of each word
 * backward. Use a stack to reverse the characters of each word.
 *
 * @author Sharaf Qeshta
 * */
public class Project_03_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        for (String word : words)
            reversedSentence.append(reverseWord(word)).append(" ");
        System.out.println(reversedSentence);
    }

    public static String reverseWord(String word)
    {
        ArrayStack<Character> characters = new ArrayStack<>();
        for (int i = 0; i < word.length(); i++)
            characters.push(word.charAt(i));
        StringBuilder reversedWord = new StringBuilder();
        while (!characters.isEmpty())
            reversedWord.append(characters.pop());
        return reversedWord.toString();
    }
}
