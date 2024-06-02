package chapter_05;

import java.util.NoSuchElementException;

public class Deque<T> implements DequeADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;


    public Deque(int initialCapacity)
    {
        rear = count = front = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }

    public Deque()
    {
        this(DEFAULT_CAPACITY);
    }

    private int increaseIndex(int index)
    {
        index++;
        if (index == queue.length)
            index = 0;
        return index;
    }

    private int decreaseIndex(int index)
    {
        index--;
        if (index < 0)
            index = queue.length - 1;
        return index;
    }

    @Override
    public void pushFront(T element)
    {
        if (count == queue.length)
            throw new IllegalStateException("The deque is full");
        front = decreaseIndex(front);
        queue[front] = element;
        count++;
    }

    @Override
    public void pushBack(T element)
    {
        if (count == queue.length)
            throw new IllegalStateException("The deque is full");
        queue[rear] = element;
        rear = increaseIndex(rear);
        count++;
    }

    @Override
    public T popFront()
    {
        T element = front();
        queue[front] = null;
        front = increaseIndex(front);
        count--;
        return element;
    }

    @Override
    public T popBack()
    {
        T element = back();
        rear = decreaseIndex(rear);
        queue[rear] = null;
        count--;
        return element;
    }

    @Override
    public T front()
    {
        if (isEmpty())
            throw new NoSuchElementException();

        return queue[front];
    }

    @Override
    public T back()
    {
        if (isEmpty())
            throw new NoSuchElementException();

        return queue[decreaseIndex(rear)];
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public int size()
    {
        return count;
    }
}
