package chapter_01;


import java.util.Arrays;
import java.util.List;

/**
 * PP 3.7 Implement an infix-to-postfix translator using stacks.
 *
 * @author Sharaf Qeshta
 * */
public class Project_03_07
{
    public static void main(String[] args)
    {
        System.out.println(translator("7+7*2-5/3")); // 7 7 2 * + 5 3 / -
        System.out.println(translator("8*2-3+6/2")); // 8 2 * 3 - 6 2 / +
        System.out.println(translator("1+2+3")); // 1 2 + 3 +
        System.out.println(translator("6-9")); // 6 9 -
        System.out.println(translator("4+5*2")); // 4 5 2 * +
    }

    public static String translator(String infix)
    {
        StringBuilder postfix = new StringBuilder();
        ArrayStack<Character> operators = new ArrayStack<>();

        for (int i = 0; i < infix.length(); i++)
        {
            char character = infix.charAt(i);
            if (Character.isDigit(character))
                postfix.append(character).append(" ");
            else
            {
                if (operators.isEmpty())
                    operators.push(character);
                else
                {
                    char top = operators.peek();
                    List<Character> higherOrEqualPrecedence = getHigherOrEqualPrecedence(character);
                    while (higherOrEqualPrecedence.contains(top))
                    {
                        postfix.append(operators.pop()).append(" ");
                        if(!operators.isEmpty())
                            top = operators.peek();
                        else
                            break;
                    }
                    operators.push(character);
                }
            }
        }

        while (!operators.isEmpty())
            postfix.append(operators.pop()).append(" ");
        return postfix.toString();
    }

    public static List<Character> getHigherOrEqualPrecedence(char operator)
    {
        if (operator == '*' || operator == '/')
            return Arrays.asList('/', '*');
        if (operator == '+' || operator == '-')
            return Arrays.asList('+', '-', '*', '/');
        return List.of();
    }
}
