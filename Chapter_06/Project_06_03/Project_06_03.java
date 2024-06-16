package chapter_06;

/**
 * PP 6.3 Implement a queue using a LinkedList object to store the queue
 * elements.
 *
 * @author Sharaf Qeshta
 * */
public class Project_06_03
{
    public static void main(String[] args)
    {
        QueueUsingLinkedList<String> queue = new QueueUsingLinkedList<>();
        queue.enqueue("San Antonio");
        queue.enqueue("Houston");
        queue.enqueue("Dallas");
        queue.enqueue("Austin");
        queue.enqueue("El Paso");

        System.out.println(queue.dequeue()); // San Antonio
        System.out.println(queue.dequeue()); // Houston
        System.out.println(queue.dequeue()); // Dallas
        System.out.println(queue.dequeue()); // Austin
        System.out.println(queue.dequeue()); // El Paso
        System.out.println(queue.dequeue()); // null "because the queue is empty"
    }
}
