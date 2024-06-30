package chapter_06;

/**
 * PP 6.9 Complete the implementation of the ArrayOrderedList class.
 *
 * @author Sharaf Qeshta
 * */
public class Project_06_09
{
    public static void main(String[] args) throws ElementNotFoundException
    {
        ArrayOrderedList<String> arrayOrderedList = new ArrayOrderedList<>();
        arrayOrderedList.add("North America");
        arrayOrderedList.add("Europe");
        arrayOrderedList.add("Asia");
        arrayOrderedList.add("South America");
        arrayOrderedList.add("Oceania");
        arrayOrderedList.add("Australia");
        arrayOrderedList.add("Antarctica");

        System.out.println();
        for (String continent : arrayOrderedList)
            System.out.println(continent);

        arrayOrderedList.remove("Australia");

        System.out.println();
        for (String continent : arrayOrderedList)
            System.out.println(continent);

        arrayOrderedList.remove("South America");
        System.out.println();
        for (String continent : arrayOrderedList)
            System.out.println(continent);

        arrayOrderedList.add("South America");
        System.out.println();
        for (String continent : arrayOrderedList)
            System.out.println(continent);
    }
}
