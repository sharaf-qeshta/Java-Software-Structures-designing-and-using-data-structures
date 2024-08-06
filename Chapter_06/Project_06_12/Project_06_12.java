package chapter_06;

/**
 * PP 6.12  Write an implementation of the LinkedOrderedList class.
 *
 * @author Sharaf Qeshta
 * */
public class Project_06_12
{
    public static void main(String[] args) throws ElementNotFoundException {
        LinkedOrderedList<String> continents = new LinkedOrderedList<>();
        continents.add("Asia");
        continents.add("Africa");
        continents.add("North America");
        continents.add("South America");
        continents.add("Europe");
        continents.add("Oceania");
        continents.add("Antarctica");

        /**
         * Africa
         * Antarctica
         * Asia
         * Europe
         * North America
         * Oceania
         * South America
         * */
        for (String continent : continents)
            System.out.println(continent);


        System.out.println(continents.contains("Asia")); // true
        System.out.println(continents.contains("Australia")); // false
    }
}
