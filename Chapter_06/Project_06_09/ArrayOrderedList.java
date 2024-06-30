package chapter_06;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayOrderedList<T extends Comparable<T>> implements OrderedListADT<T>
{
    private final int DEFAULT_SIZE = 100;
    private T[] list;
    private int count;

    public ArrayOrderedList()
    {
        list = (T[]) new Comparable[DEFAULT_SIZE];
        count = 0;
    }
    @Override
    public T removeFirst() throws ElementNotFoundException
    {
        if (isEmpty())
            throw new ElementNotFoundException("the list is empty");

        T element = list[0];
        for (int i = 0; i < count-1; i++)
            list[i] = list[i+1];
        list[count-1] = null;
        count--;
        return element;
    }

    @Override
    public T removeLast() throws ElementNotFoundException
    {
        if (isEmpty())
            throw new ElementNotFoundException("the list is empty");

        T element = list[count-1];
        list[count-1] = null;
        count--;
        return element;
    }

    @Override
    public T remove(T element) throws ElementNotFoundException
    {
        int index = indexOf(element);
        if (index == -1)
            throw new ElementNotFoundException("element " + element + " not found in the list");
        list[index] = null;
        for (int i = index; i < count-1; i++)
            list[i] = list[i+1];
        list[count-1] = null;
        count--;
        return element;
    }

    @Override
    public T first()
    {
        return list[0];
    }

    @Override
    public T last()
    {
        if (isEmpty())
            return null;
        return list[count-1];
    }

    private Integer indexOf(T element)
    {
        for (int i = 0; i < count; i++)
            if (list[i].compareTo(element) == 0)
                return i;
        return -1;
    }

    @Override
    public boolean contains(T target)
    {
        for (int i = 0; i < count; i++)
            if (list[i].compareTo(target) == 0)
                return true;
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        return count == 0;
    }

    @Override
    public int size()
    {
        return count;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            int index = 0;
            @Override
            public boolean hasNext()
            {
                return index < count;
            }

            @Override
            public T next()
            {
                return list[index++];
            }
        };
    }

    private void expandList()
    {
        list = Arrays.copyOf(list, list.length * 2);
    }

    private void add(int index, T element)
    {
        T current = element;
        T next;
        for (int i = index; i < size(); i++)
        {
            next = list[i];
            list[i] = current;
            current = next;
        }
        list[size()] = current;
        count++;
    }

    @Override
    public void add(T element)
    {
        if (count == list.length)
            expandList();

        if (isEmpty())
        {
            list[count] = element;
            count++;
            return;
        }

        boolean placed = false;
        for (int i = 0; i < size(); i++)
        {
            if (list[i].compareTo(element) > 0)
            {
                add(i, element);
                placed = true;
                break;
            }
        }
        if (!placed)
        {
            list[count] = element;
            count++;
        }
    }
}
