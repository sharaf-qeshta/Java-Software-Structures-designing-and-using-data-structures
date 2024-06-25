package chapter_06;

public class ElementNotFoundException extends Exception
{
    public ElementNotFoundException(String element)
    {
        super(element + " element not found");
    }
}
