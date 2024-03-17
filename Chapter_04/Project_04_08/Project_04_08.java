package chapter_04;

/**
 * PP 4.8 There is a data structure called a drop-out stack that behaves like
 * a stack in every respect except that if the stack size is n, then
 * when the n+1 element is pushed, the first element is lost.
 * Implement a drop-out stack using links.
 *
 * @author Sharaf Qehsta
 * */
public class Project_04_08
{
    public static void main(String[] args)
    {
        DropOutStack<String> clicks = new DropOutStack<>(4);
        clicks.push("Up");
        clicks.push("Down");
        clicks.push("Up");
        clicks.push("Left");
        clicks.push("Right");
        clicks.push("Right");
        clicks.push("Right");
        clicks.push("Right");
        clicks.push("Right");
        System.out.println(clicks.peek()); // Right
        System.out.println(clicks.size()); // 4
        System.out.println(clicks); // {Right, Right, Right, Right}
    }
}
