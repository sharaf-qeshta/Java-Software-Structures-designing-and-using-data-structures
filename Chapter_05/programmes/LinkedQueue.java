package chapter_05.programmes;

/**
 * LinkedQueue represents a linked implementation of a queue.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class LinkedQueue<T> implements QueueADT<T>
{
    private int count;
    private LinearNode<T> head, tail;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue()
    {
        count = 0;
        head = tail = null;
    }

    public void enqueue(T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);
        if (isEmpty())
            head = node;
        else
            tail.setNext(node);
        tail = node;
        count++;
    }

    /**
     * Removes the element at the head of this queue and returns a
     * reference to it.
     *
     * @return the element at the head of this queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
        T result = head.getElement();
        head = head.getNext();
        count--;
        if (isEmpty())
            tail = null;
        return result;
    }

    @Override
    public T first()
    {
        return null;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public int size()
    {
        return 0;
    }
}