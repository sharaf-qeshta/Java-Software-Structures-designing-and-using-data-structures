package chapter_04;


import java.util.Scanner;

/**
 * PP 4.2 Modify the postfix program from Chapter 3 so that it uses the
 * LinkedStack<T> class instead of the ArrayStack<T> class.
 *
 * @author Sharaf Qeshta
 * */
public class Project_02_02
{
    public static void main(String[] args)
    {
        String expression, again;
        int result;

        Scanner in = new Scanner(System.in);

        do
        {
            PostfixEvaluator evaluator = new PostfixEvaluator();
            System.out.println("Enter a valid post-fix expression one token " +
                    "at a time with a space between each token " +
                    "(e.g. 5 4 + 3 2 1 - + *)");
            System.out.println("Each token must be an integer or an " +
                    "operator (+,-,*,/)");
            expression = in.nextLine();
            result = evaluator.evaluate(expression);
            System.out.println();
            System.out.println("That expression equals " + result);
            System.out.print("Evaluate another expression [Y/N]? ");
            again = in.nextLine();
            System.out.println();
        }
        while (again.equalsIgnoreCase("y"));
    }
}
