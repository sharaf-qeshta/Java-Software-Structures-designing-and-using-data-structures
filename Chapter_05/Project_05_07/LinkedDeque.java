package chapter_05;

public class LinkedDeque<T> implements DequeADT<T>
{
    private int count;
    private DequeNode<T> head, tail;

    public LinkedDeque()
    {
        count = 0;
        head = tail = null;
    }

    @Override
    public void pushFront(T element)
    {
        DequeNode<T> node = new DequeNode<>(element);
        if (head == null)
            head = tail = node;
        else
        {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        count++;
    }

    @Override
    public void pushBack(T element)
    {
        DequeNode<T> node = new DequeNode<>(element);
        if (tail == null)
            head = tail = node;
        else
        {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        count++;
    }

    @Override
    public T popFront()
    {
        if (head == null)
            throw new IllegalStateException("The head is Empty");
        else
        {
            T temp = head.getElement();
            head = head.getNext();
            if (head == null)
                tail = null;
            else
                head.setPrevious(null);
            count--;
            return temp;
        }
    }

    @Override
    public T popBack()
    {
        if (head == null)
            throw new IllegalStateException("The head is Empty");
        else
        {
            T temp = tail.getElement();
            tail = tail.getPrevious();
            if (tail == null)
                head = null;
            else
                tail.setNext(null);
            count--;
            return temp;
        }
    }

    @Override
    public T front()
    {
        return (head == null)? null : head.getElement();
    }

    @Override
    public T back()
    {
        return (tail == null)? null : tail.getElement();
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
}
