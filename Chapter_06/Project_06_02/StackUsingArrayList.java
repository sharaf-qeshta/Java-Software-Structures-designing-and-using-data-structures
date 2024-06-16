package chapter_06;


import java.util.ArrayList;

public class StackUsingArrayList<T> implements StackADT<T>
{
    private ArrayList<T> list;


    @Override
    public void push(T element)
    {
        list.add(element);
    }

    @Override
    public T pop()
    {
        // removes the last element
        return list.remove(list.size()-1);
    }

    @Override
    public T peek()
    {
        return list.get(list.size()-1);
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
