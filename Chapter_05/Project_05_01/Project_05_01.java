package chapter_05;


/**
 * PP 5.1 Complete the implementation of the LinkedQueue class presented
 * in this chapter. Specifically, complete the implementations of the
 * first, isEmpty, size, and toString methods.
 *
 * @author Sharaf Qeshta
 * */
public class Project_05_01
{
    public static void main(String[] args)
    {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.first()); // 1
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.size()); // 5
        System.out.println(queue); // {1, 2, 3, 4, 5}
    }
}
