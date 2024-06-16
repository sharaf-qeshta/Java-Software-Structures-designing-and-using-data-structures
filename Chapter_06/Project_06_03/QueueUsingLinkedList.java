package chapter_06;

import java.util.LinkedList;

public class QueueUsingLinkedList<T> implements QueueADT<T>
{

    private LinkedList<T> list;

    public QueueUsingLinkedList()
    {
            list = new LinkedList<>();
    }

    @Override
    public void enqueue(T element)
    {
        list.add(element);
    }

    @Override
    public T dequeue()
    {
        if (isEmpty())
            return null;
        return list.remove(0);
    }

    @Override
    public T first()
    {
        return list.get(0);
    }

    @Override
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    @Override
    public int size()
    {
        return list.size();
    }
}
