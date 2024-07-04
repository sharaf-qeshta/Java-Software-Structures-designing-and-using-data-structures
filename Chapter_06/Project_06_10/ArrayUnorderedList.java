package chapter_06;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayUnorderedList<T extends Comparable<T>> implements UnorderedListADT<T>
{
    private final int DEFAULT_SIZE = 100;
    private T[] list;
    private int count;

    public ArrayUnorderedList()
    {
        count = 0; list = (T[]) new Comparable[DEFAULT_SIZE];
    }


    @Override
    public T removeFirst() throws ElementNotFoundException
    {
        if (isEmpty())
            throw new ElementNotFoundException("The list is empty");
        T first = list[0];
        for (int i = 0; i < count-1; i++)
            list[i] = list[i+1];
        list[count-1] = null;
        count--;
        return first;
    }

    @Override
    public T removeLast() throws ElementNotFoundException
    {
        if (isEmpty())
            throw new ElementNotFoundException("The list is empty");
        T last = list[count-1];
        list[count-1] = null;
        count--;
        return last;
    }

    @Override
    public T remove(T element) throws ElementNotFoundException
    {
        int index = -1;
        for (int i = 0; i < count; i++)
            if (list[i].compareTo(element) == 0)
            {
                index = i; break;
            }

        if (index == -1)
            throw new ElementNotFoundException("Element " + element + " not found");
        T removed = list[index];

        for (int i = index; i < count-1; i++)
            list[i] = list[i+1];
        list[count-1] = null;
        count--;
        return removed;
    }

    @Override
    public T first()
    {
        return list[0];
    }

    @Override
    public T last()
    {
        return (isEmpty())? null : list[count-1];
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
            private int index = 0;
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

    @Override
    public void addToFront(T element)
    {
        if (count == list.length)
            expandList();
        T current = list[0];
        for (int i = 0; i < count-1; i++)
        {
            T temp = list[i+1];
            list[i+1] = current;
            current = temp;
        }
        list[count] = current;
        list[0] = element;
        count++;
    }

    @Override
    public void addToRear(T element)
    {
        if (count == list.length)
            expandList();

        list[count++] = element;
    }

    private Integer indexOf(T element)
    {
        for (int i = 0; i < count; i++)
            if (list[i].compareTo(element) == 0)
                return i;
        return -1;
    }

    @Override
    public void addAfter(T element, T target)
    {
        if (count == list.length)
            expandList();
        Integer index = indexOf(element);
        if (index == -1)
            addToRear(element);
        else
        {
            T current = list[index];
            for (int i = index; i < count-1; i++)
            {
                T temp = list[i+1];
                list[i+1] = current;
                current = temp;
            }
            list[count] = current;
            list[index+1] = target;
            count++;
        }
    }
}
