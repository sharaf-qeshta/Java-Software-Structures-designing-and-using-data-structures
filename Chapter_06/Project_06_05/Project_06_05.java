package chapter_06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PP 6.5 Implement the Josephus problem using a queue, and compare the
 * performance of that algorithm to the ArrayList implementation
 * from this chapter.
 *
 * @author Sharaf Qeshta
 * */
public class Project_06_05
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(josephus(queue, 3));
    }

    public static int josephus(Queue<Integer> list, int k)
    {
        int i = 1;
        while (list.size() > 1)
        {
            Integer person = list.remove();
            if (i % k != 0)
                list.add(person);
            else
                System.out.println(person);
            i++;
        }
        return list.remove();
    }
}
