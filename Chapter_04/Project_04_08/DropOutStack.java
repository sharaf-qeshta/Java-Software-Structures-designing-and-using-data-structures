package chapter_04;

public class DropOutStack<T> implements StackADT<T>
{
    private int count;
    private int n;
    private LinearNode<T> top;

    public DropOutStack()
    {
        this(10);
    }

    public DropOutStack(int n)
    {
        this.n = n;
        top = null;
        count = 0;
    }

    @Override
    public void push(T element)
    {
        if (count == n)
        {
             try
             {
                 LinearNode<T> current = top;
                 int counter = 0;
                 while (current != null)
                 {
                     counter++;
                     if (counter == n-1)
                         break;
                     current = current.getNext();
                 }
                 current.setNext(null);
             }
             catch (NullPointerException exception)
             {
                 System.out.println(exception.getMessage());
             }
        }
        else
            count++;

        LinearNode<T> temp = new LinearNode<>(element);
        temp.setNext(top);
        top = temp;
    }

    @Override
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    @Override
    public T peek()
    {
        return top.getElement();
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
    public String toString()
    {
        StringBuilder returnedString = new StringBuilder("{");
        LinearNode<T> current = top;
        if (current == null)
            return "{}";

        while (current.getNext() != null)
        {
            returnedString.append(current.getElement().toString()).append(", ");
            current = current.getNext();
        }

        return returnedString + current.getElement().toString() + "}";
    }
}
