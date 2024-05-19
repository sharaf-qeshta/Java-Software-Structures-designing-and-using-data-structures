package chapter_05;

public class LinkedQueueWithoutCount<T> implements QueueADT<T>
{
    private LinearNode<T> head, tail;

    /**
     * Creates an empty queue.
     */
    public LinkedQueueWithoutCount()
    {
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
        if (isEmpty())
            tail = null;
        return result;
    }

    @Override
    public T first()
    {
        return (head == null)? null : head.getElement();
    }

    @Override
    public boolean isEmpty()
    {
        return head == null && tail == null;
    }

    @Override
    public int size()
    {
        int size = 0;
        LinearNode<T> current = this.head;
        while (current != null)
        {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public String toString()
    {
        String result = "{";
        LinearNode<T> current = this.head;
        while (current != null)
        {
            result += current.getElement() + ", ";
            current = current.getNext();
        }
        if (head != null)
            result = result.substring(0, result.length()-2);

        return result + "}";
    }
}
