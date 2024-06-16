package chapter_06;

import chapter_04.StackADT;

import java.util.LinkedList;

public class StackUsingLinkedList<T> implements StackADT<T>
{
    private LinkedList<T> list;

    public StackUsingLinkedList()
    {
        list = new LinkedList<>();
    }

    @Override
    public void push(T element)
    {
        list.push(element);
    }

    @Override
    public T pop()
    {
        return list.pop();
    }

    @Override
    public T peek()
    {
        return list.peek();
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
