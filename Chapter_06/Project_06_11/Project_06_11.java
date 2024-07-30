package chapter_06;

/**
 * PP 6.11 Write an implementation of the LinkedList class.
 *
 * @author Sharaf Qeshta
 * */
public class Project_06_11
{
    public static void main(String[] args) throws ElementNotFoundException {
        LinkedList<String> list = new LinkedList<>();
        list.add("London");
        list.add("Washington");
        list.add("Ottawa");
        list.add("Cairo");
        list.add("Jerusalem");
        list.add("Dubai");


        System.out.println(list.removeFirst()); // London
        System.out.println(list.removeLast()); // Dubai

        for (String city : list)
            System.out.println(city);

        System.out.println(list.isEmpty()); // false
        System.out.println(list.first()); // Washington
        System.out.println(list.last()); // Jerusalem
        System.out.println(list.remove("Ottawa")); // Ottawa

        for (String city : list)
            System.out.println(city);

        System.out.println(list.size()); // 3
        System.out.println(list.contains("Washington")); // true
        System.out.println(list.contains("London")); // false
    }
}
