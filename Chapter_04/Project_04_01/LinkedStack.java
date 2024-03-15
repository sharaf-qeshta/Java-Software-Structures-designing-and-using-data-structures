package chapter_02;

/**
 * Represents a linked implementation of a stack.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class LinkedStack<T> implements StackADT<T>
{
    private int count;
    private LinearNode<T> top;

    /**
     * Creates an empty stack.
     */
    public LinkedStack()
    {
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     *
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     *
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
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
