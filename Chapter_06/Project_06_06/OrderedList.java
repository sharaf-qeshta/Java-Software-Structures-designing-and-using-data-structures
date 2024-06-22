package chapter_06;

import java.util.Iterator;
import java.util.LinkedList;

public class OrderedList<T extends Comparable<T>> implements OrderedListADT<T>
{
    private final LinkedList<T> list;

    public OrderedList()
    {
        list = new LinkedList<>();
    }

    @Override
    public T removeFirst()
    {
        return list.removeFirst();
    }

    @Override
    public T removeLast()
    {
        return list.removeLast();
    }

    @Override
    public T remove(T element) throws ElementNotFoundException
    {
        if (!contains(element))
            throw new ElementNotFoundException(element + "");
        return list.remove(list.indexOf(element));
    }

    @Override
    public T first()
    {
        return list.getFirst();
    }

    @Override
    public T last()
    {
        return list.getLast();
    }

    @Override
    public boolean contains(T target)
    {
        return list.contains(target);
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

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private int i = 0;

            @Override
            public boolean hasNext()
            {
                return i < list.size();
            }

            @Override
            public T next()
            {
                T item = list.get(i++);
                return item;
            }
        };
    }

    @Override
    public void add(T element)
    {
        if (isEmpty())
            list.add(element);

        boolean placed = false;
        for (int i = 0; i < size(); i++)
        {
            if (list.get(i).compareTo(element) < 0)
            {
                list.add(i, element);
                placed = true;
                break;
            }
        }
        if (!placed)
            list.add(element);
    }
}
