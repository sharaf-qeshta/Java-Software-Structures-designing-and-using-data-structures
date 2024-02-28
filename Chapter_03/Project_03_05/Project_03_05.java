package chapter_01;

/**
 * PP 3.5 There is a data structure called a drop-out stack that behaves like a
 * stack in every respect except that if the stack size is n, when the n + 1
 * element is pushed, the first element is lost. Implement a drop-out
 * stack using an array. (Hint: A circular array implementation would
 * make sense.)
 *
 * @author Sharaf Qeshta
 * */
public class Project_03_05
{
    public static void main(String[] args)
    {
        DropOutStack<String> stack = new DropOutStack<>(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("right click");
        System.out.println(stack.pop()); // right click
        System.out.println(stack.pop()); // c
        System.out.println(stack.pop()); // b
        System.out.println(stack.pop()); // Exception: The stack is empty.
    }
}
