package chapter_01;

/**
 * PP 3.1 Complete the implementation of the ArrayStack class presented
 * in this chapter. Specifically, complete the implementations of the
 * isEmpty, size, and toString methods.
 *
 * @author Sharaf Qeshta
 * */
public class Project_03_01
{
    public static void main(String[] args)
    {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("Sharaf");
        stack.push("Keshta");
        stack.push("Lives");
        stack.push("In");
        stack.push("Houston");

        System.out.println(stack.size()); // 5
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack); // {Houston, In, Lives, Keshta, Sharaf}
    }
}


