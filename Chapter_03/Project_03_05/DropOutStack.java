package chapter_01;

public class DropOutStack<T> implements StackADT<T>
{
    private final static int DEFAULT_SIZE = 10;
    private int top;
    private final T[] stack;

    public DropOutStack()
    {
        this(DEFAULT_SIZE);
    }

    public DropOutStack(int size)
    {
        top = -1;
        stack = (T[]) (new Object[size]);
    }

    public void push(T element)
    {
        if (size() == stack.length)
            // Drop the first element
            dropFirst();
        else
            top++;
        stack[top] = element;
    }

    private void dropFirst()
    {
        for (int i = 0; i < top; i++)
            stack[i] = stack[i+1];
    }

    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        T result = stack[top];
        stack[top] = null;
        top--;
        return result;
    }

    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        return stack[top];
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public int size()
    {
        return top+1;
    }
}
