package chapter_05;

public class DequeNode<T>
{
    private DequeNode<T> next, previous;
    private T element;

    public DequeNode()
    {
        next = null;
        previous = null;
        element = null;
    }

    /**
     * Creates a node storing the specified element.
     *
     * @param element_ element to be stored
     */
    public DequeNode(T element_)
    {
        next = null;
        previous = null;
        element = element_;
    }

    /**
     * Returns the node that follows this one.
     *
     * @return reference to next node
     */
    public DequeNode<T> getNext()
    {
        return next;
    }

    /**
     * Returns the node that comes before this one.
     *
     * @return reference to previous node
     */
    public DequeNode<T> getPrevious()
    {
        return previous;
    }

    /**
     * Sets the node that follows this one.
     *
     * @param node node to follow this one
     */
    public void setNext(DequeNode<T> node)
    {
        next = node;
    }

    /**
     * Sets the node that comes before this one.
     *
     * @param node node to comes before this one
     */
    public void setPrevious(DequeNode<T> node)
    {
        previous = node;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return element stored at the node
     */
    public T getElement()
    {
        return element;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param element_ element to be stored at this node
     */
    public void setElement(T element_)
    {
        element = element_;
    }
}
