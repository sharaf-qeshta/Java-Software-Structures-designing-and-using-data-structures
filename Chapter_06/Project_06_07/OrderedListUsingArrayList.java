package chapter_06;


import java.util.ArrayList;
import java.util.Iterator;

public class OrderedListUsingArrayList<T extends Comparable<T>> implements OrderedListADT<T>
{
    private final ArrayList<T> list;

    public OrderedListUsingArrayList()
    {
        list = new ArrayList<>();
    }

    @Override
    public T removeFirst()
    {
        if (isEmpty())
            return null;
        return list.remove(0);
    }

    @Override
    public T removeLast()
    {
        if (isEmpty())
            return null;
        return list.remove(size()-1);
    }

    @Override
    public T remove(T element) throws ElementNotFoundException
    {
        if (!contains(element))
            return null;
        return list.remove(list.indexOf(element));
    }

    @Override
    public T first()
    {
        if (list.isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    public T last()
    {
        if (list.isEmpty())
            return null;
        return list.get(size()-1);
    }

    @Override
    public boolean contains(T target)
    {
        return list.contains(target);
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public int size()
    {
        return list.size();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<>()
        {
            private int index = 0;
            @Override
            public boolean hasNext()
            {
                return index < size();
            }

            @Override
            public T next()
            {
                return list.get(index++);
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
