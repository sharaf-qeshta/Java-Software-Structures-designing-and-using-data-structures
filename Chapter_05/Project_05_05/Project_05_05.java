package chapter_05;

/**
 * PP 5.5 All of the implementations in this chapter use a count variable to
 * keep track of the number of elements in the queue. Rewrite the
 * circular array implementation without a count variable.
 *
 * @author Sharaf Qeshta
 * */
public class Project_05_05
{
    public static void main(String[] args)
    {
        CircularArrayQueueWithoutCount<Integer> queueWithoutCount = new CircularArrayQueueWithoutCount<>();
        for (int i = 0; i < 100; i++)
            queueWithoutCount.enqueue(i);
        System.out.println(queueWithoutCount.size()); // 100
        System.out.println(queueWithoutCount.first()); // 0
        System.out.println(queueWithoutCount.isEmpty()); // false
        queueWithoutCount.dequeue();
        queueWithoutCount.dequeue();
        queueWithoutCount.dequeue();
        System.out.println(queueWithoutCount.size()); // 97
        System.out.println(queueWithoutCount.first()); // 3
    }
}
