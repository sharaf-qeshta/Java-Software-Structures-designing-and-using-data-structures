package chapter_05;

public interface DequeADT<T>
{
    /**
     * Adds one element to the front of this queue.
     * @param element the element to be added to the front of the queue
     */
    void pushFront(T element);

    /**
     * Adds one element to the end of this queue.
     * @param element the element to be added to the end of the queue
     */
    void pushBack(T element);

    /**
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     */
    T popFront();


    /**
     * Removes and returns the element at the end of this queue.
     * @return the element at the end of the queue
     */
    T popBack();


    /**
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     */
    T front();


    /**
     * Returns without removing the element at the end of this queue.
     * @return the last element in the queue
     */
    T back();


    /**
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     * @return the integer representation of the size of the queue
     */
    int size();

    /**
     * Returns a string representation of this queue.
     * @return the string representation of the queue
     */
    String toString();
}
