package chapter_01;

import java.util.Scanner;

/**
 * PP 3.8 Implement a class called reverse that uses a stack to output a set
 * of elements input by the user in reverse order.
 *
 * @author Sharaf Qeshta
 * */
public class Project_03_08
{
    /**
     * How many Items you want to insert: 5
     * london jerusalem washington beijing moscow
     * moscow beijing washington jerusalem london
     * */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many Items you want to insert: ");
        int numberOfItems = scanner.nextInt();

        ArrayStack<String> strings = new ArrayStack<>();
        for (int i = 0; i < numberOfItems; i++)
        {
            strings.push(scanner.next());
        }
        while (!strings.isEmpty())
            System.out.print(strings.pop() + " ");
    }
}
