package chapter_01;

/**
 * PP 3.6 Implement an integer adder using three stacks.
 *
 * @author Sharaf Qeshta
 */
public class Project_03_06
{
    public static void main(String[] args)
    {
        System.out.println(integerAdder("10", "50")); // 60
        System.out.println(integerAdder("111", "3")); // 114
        System.out.println(integerAdder("12", "4")); // 16
        System.out.println(integerAdder("5", "3")); // 8
    }

    public static int integerAdder(String num1,
                                   String num2)
    {
        ArrayStack<Integer> num1Stack = new ArrayStack<>();
        for (int i = 0; i < num1.length(); i++)
            num1Stack.push(Character.getNumericValue(num1.charAt(i)));

        ArrayStack<Integer> num2Stack = new ArrayStack<>();
        for (int i = 0; i < num2.length(); i++)
            num2Stack.push(Character.getNumericValue(num2.charAt(i)));

        int result = 0;

        int i = 0;
        while (!num1Stack.isEmpty() & !num2Stack.isEmpty())
        {
            int factor = (int) Math.pow(10, i++);
            result += num1Stack.pop() * factor + num2Stack.pop() * factor;
        }

        if (!num1Stack.isEmpty())
            while (!num1Stack.isEmpty())
            {
                int factor = (int) Math.pow(10, i++);
                result += num1Stack.pop() * factor;
            }
        else if (!num2Stack.isEmpty())
            while (!num2Stack.isEmpty())
            {
                int factor = (int) Math.pow(10, i++);
                result += num2Stack.pop() * factor;
            }

        return result;
    }
}
