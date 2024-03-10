package chapter_02;

/**
 * PP 4.1 Complete the implementation of the LinkedStack<T> class by
 * providing definitions for the peek, size, isEmpty, and toString
 * methods.
 *
 * @author Sharaf Qeshta
 * */
public class Project_02_01
{
    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("USA");
        linkedStack.push("UK");
        linkedStack.push("Russia");
        linkedStack.push("China");
        linkedStack.push("UAE");

        System.out.println(linkedStack.peek()); // UAE
        System.out.println(linkedStack.size()); // 5
        System.out.println(linkedStack.isEmpty()); // false
        System.out.println(linkedStack); // {UAE, China, Russia, UK, USA}
    }
}
