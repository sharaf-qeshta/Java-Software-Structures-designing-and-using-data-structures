package chapter_06;

import java.util.Iterator;

public class LinkedList<T> implements ListADT<T>
{
    private int count;
    private LinearNode<T> head, tail;

    public LinkedList()
    {
        count = 0;
        head = tail = null;
    }

    public void add(T element)
    {
        LinearNode<T> node = new LinearNode<>(element);
        if (isEmpty())
            head = node;
        else
            tail.setNext(node);
        tail = node;
        count++;
    }

    @Override
    public T removeFirst() throws ElementNotFoundException
    {
        T element = null;
        LinearNode<T> next = null;
        if (count != 0 && head != null)
        {
            count--;
            element = head.getElement();
            next = head.getNext();
        }
        head = next;
        return element;
    }

    @Override
    public T removeLast() throws ElementNotFoundException
    {
        if (head == null)
            return null;

        if (head.getNext() == null)
            return null;

        LinearNode<T> second_last = head;
        while (second_last.getNext().getNext() != null)
            second_last = second_last.getNext();


        T element = second_last.getNext().getElement();
        second_last.setNext(null);
        tail = second_last;
        count--;
        return element;
    }

    @Override
    public T remove(T element) throws ElementNotFoundException
    {
        LinearNode<T> current = head;
        LinearNode<T> previous = null;
        LinearNode<T> next = null;
        while (current != null)
        {
            if (current.getElement().equals(element))
            {
                next = current.getNext();
                break;
            }
            previous = current;
            current = current.getNext();
        }

        if (next == null)
            throw new ElementNotFoundException("Can`t find element " + element + " in the list");
        if (previous == null)
            head = next;
        else
            previous.setNext(next);
        count--;
        return element;
    }

    @Override
    public T first()
    {
        if (head != null)
            return head.getElement();
        return null;
    }

    @Override
    public T last()
    {
        if (tail != null)
            return tail.getElement();
        return null;
    }

    @Override
    public boolean contains(T target)
    {
        LinearNode<T> current = head;
        while (current != null)
        {
            if (current.getElement().equals(target))
                return true;
            current = current.getNext();
        }
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
            LinearNode<T> currentNode = head;
            @Override
            public boolean hasNext()
            {
                return currentNode != null;
            }

            @Override
            public T next()
            {
                T element = currentNode.getElement();
                currentNode = currentNode.getNext();
                return element;
            }
        };
    }
}
