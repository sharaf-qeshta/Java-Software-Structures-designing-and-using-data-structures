package chapter_05;

/**
 * PP 5.6 A data structure called a deque is closely related to a queue. The
 * name deque stands for “double-ended queue.” The difference
 * between the two is that with a deque, you can insert, remove, or
 * view from either end of the queue. Implement a deque using
 * arrays.
 *
 * @author Sharaf Qeshta
 * */
public class Project_05_06
{
    public static void main(String[] args)
    {
        Deque<String> deque = new Deque<>();
        deque.pushFront("USA");
        deque.pushBack("China");
        deque.pushFront("Uk");
        deque.pushFront("Germany");
        deque.pushBack("Russia");

        System.out.println(deque.popBack()); // Russia
        System.out.println(deque.popFront()); // Germany

        System.out.println(deque.front()); // UK
        System.out.println(deque.back()); // China
        System.out.println(deque.size()); // 3
        System.out.println(deque.isEmpty()); // False
    }
}
