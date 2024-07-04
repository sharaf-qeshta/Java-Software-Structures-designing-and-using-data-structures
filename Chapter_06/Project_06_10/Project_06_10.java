package chapter_06;

/**
 *  PP 6.10 Complete the implementation of the ArrayUnorderedList class.
 *
 * @author Sharaf Qeshta
 * */
public class Project_06_10
{
    public static void main(String[] args) throws ElementNotFoundException
    {
        ArrayUnorderedList<String> list = new ArrayUnorderedList<>();
        list.addToRear("United States");
        list.addToRear("Egypt");
        list.addToRear("Saudi");
        list.addToRear("China");
        list.addToFront("Japan");
        list.addToFront("Pakistan");
        list.addToFront("Qatar");
        list.addToRear("Spain");
        list.addAfter("China", "South Korea");
        list.addAfter("Spain", "United Arab Emirates");

        list.remove("Japan");
        list.remove("South Korea");

        list.addToFront("Palestine");

        for (String country : list)
            System.out.println(country);
    }
}
