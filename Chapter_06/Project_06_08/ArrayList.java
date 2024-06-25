package chapter_06;


import java.util.Arrays;
import java.util.Iterator;

/**
 * ArrayList represents an array implementation of a list. The front of
 * the list is kept at array index 0. This class will be extended
 * to create a specific kind of list.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public abstract class ArrayList<T> implements ListADT<T>, Iterable<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private final static int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;

    @Override
    public T removeFirst() throws ElementNotFoundException
    {
        return remove(list[0]);
    }

    @Override
    public T removeLast() throws ElementNotFoundException
    {
        return remove(list[list.length-1]);
    }

    @Override
    public T first()
    {
        return list[0];
    }

    @Override
    public T last()
    {
        return list[list.length-1];
    }

    @Override
    public boolean isEmpty()
    {
        return list.length == 0;
    }

    @Override
    public int size()
    {
        return list.length;
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
                return index < list.length;
            }

            @Override
            public T next()
            {
                return list[index++];
            }
        };
    }

    protected int modCount;

    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayList()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty list using the specified capacity.
     *
     * @param initialCapacity the size of the array list
     */
    public ArrayList(int initialCapacity)
    {
        rear = 0;
        list = (T[]) (new Object[initialCapacity]);
        modCount = 0;
    }

    private void expandCapacity()
    {
        list = Arrays.copyOf(list, list.length * 2);
    }

    /**
     * Removes and returns the specified element.
     *
     * @param element the element to be removed and returned from the list
     * @return the removed element
     * @throws ElementNotFoundException if the element is not in the list
     */
    public T remove(T element) throws ElementNotFoundException
    {
        T result;
        int index = find(element);
        if (index == NOT_FOUND)
            throw new ElementNotFoundException("ArrayList");
        result = list[index];
        rear--;

        // shift the appropriate elements
        for (int scan = index; scan < rear; scan++)
            list[scan] = list[scan + 1];
        list[rear] = null;
        modCount++;
        return result;
    }

    /**
     * Returns the array index of the specified element, or the
     * constant NOT_FOUND if it is not found.
     *
     * @param target the target element
     * @return the index of the target element, or the
     * NOT_FOUND constant
     */
    private int find(T target)
    {
        int scan = 0;
        int result = NOT_FOUND;
        if (!isEmpty())
            while (result == NOT_FOUND && scan < rear)
                if (target.equals(list[scan]))
                    result = scan;
                else
                    scan++;
        return result;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param target the target element
     * @return true if the target is in the list, false otherwise
     */
    public boolean contains(T target)
    {
        return (find(target) != NOT_FOUND);
    }

    /**
     * Adds the specified Comparable element to this list, keeping
     * the elements in sorted order.
     *
     * @param element the element to be added to the list
     */
    public void add(T element) throws NonComparableElementException
    {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("OrderedList");

        Comparable<T> comparableElement = (Comparable<T>) element;

        if (size() == list.length)
            expandCapacity();
        int scan = 0;
        // find the insertion location
        while (scan < rear && comparableElement.compareTo(list[scan]) > 0)
            scan++;
        // shift existing elements up one
        for (int shift = rear; shift > scan; shift--)
            list[shift] = list[shift - 1];
        // insert element
        list[scan] = element;
        rear++;
        modCount++;
    }

    /**
     * Adds the specified element after the specified target element.
     * Throws an ElementNotFoundException if the target is not found.
     *
     * @param element the element to be added after the target element
     * @param target  the target that the element is to be added after
     */
    public void addAfter(T element, T target) throws ElementNotFoundException
    {
        if (size() == list.length)
            expandCapacity();
        int scan = 0;

        // find the insertion point
        while (scan < rear && !target.equals(list[scan]))
            scan++;

        if (scan == rear)
            throw new ElementNotFoundException("UnorderedList");

        scan++;
        // shift elements up one
        for (int shift = rear; shift > scan; shift--)
            list[shift] = list[shift - 1];
        // insert element
        list[scan] = element;
        rear++;
        modCount++;
    }
}
