package chapter_06;

import java.util.ArrayList;

public class QueueUsingArrayList<T> implements QueueADT<T>
{
    private ArrayList<T> list;

    public QueueUsingArrayList()
    {
        list = new ArrayList<>();
    }


    @Override
    public void enqueue(T element)
    {
        list.add(element);
    }

    @Override
    public T dequeue()
    {
        if(isEmpty())
            return null;
        return list.remove(0);
    }

    @Override
    public T first()
    {
        if (isEmpty())
            return null;
        return list.remove(0);
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
