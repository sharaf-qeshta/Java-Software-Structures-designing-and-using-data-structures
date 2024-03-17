package chapter_04;

/**
 * PP 4.7 The linked implementation in this chapter uses a count variable
 * to keep track of the number of elements in the stack. Rewrite the
 * linked implementation without a count variable.
 *
 * @author Sharaf Qeshta
 * */
public class Project_04_07
{
    public static void main(String[] args)
    {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("North America");
        stack.push("South America");
        stack.push("Europe");
        stack.push("Asia");
        stack.push("Africa");
        stack.push("Australia");
        stack.push("Antarctica");

        System.out.println(stack.pop()); // Antarctica
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.size()); // 6
        System.out.println(stack); // {Australia, Africa, Asia, Europe, South America, North America}
    }
}
