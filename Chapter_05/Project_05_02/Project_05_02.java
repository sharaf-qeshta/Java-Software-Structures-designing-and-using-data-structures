package chapter_05;

/**
 * PP 5.2 Complete the implementation of the CircularArrayQueue class
 * described in this chapter, including all methods.
 *
 * @author Sharaf Qeshta
 * */
public class Project_05_02
{
    public static void main(String[] args)
    {
        CircularArrayQueue<Integer> circularQueue = new CircularArrayQueue<>();
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(4);
        circularQueue.enqueue(7);
        circularQueue.enqueue(8);
        circularQueue.enqueue(3);

        System.out.println(circularQueue.first()); // 1
        System.out.println(circularQueue.isEmpty()); // false
        System.out.println(circularQueue.size()); // 6
        System.out.println(circularQueue); // {1, 2, 4, 7, 8, 3}
    }
}
