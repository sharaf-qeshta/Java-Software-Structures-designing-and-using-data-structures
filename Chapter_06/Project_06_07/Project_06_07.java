package chapter_06;

/**
 * PP 6.7 Implement an OrderedList using an ArrayList object to store
 * the list elements.
 *
 * @author Sharaf Qeshta
 * */
public class Project_06_07
{
    public static void main(String[] args) throws ElementNotFoundException
    {
        OrderedListUsingArrayList<Integer> list = new OrderedListUsingArrayList<>();
        list.add(2);
        list.add(3);
        list.add(0);
        list.add(-5);
        list.add(10);
        list.add(4);
        list.add(-4);
        for (int item : list)
            System.out.print(item + " "); // 10 4 3 2 2 0 -4 -5

        System.out.println();
        list.removeFirst();
        for (int item : list)
            System.out.print(item + " "); // 4 3 2 2 0 -4 -5

        System.out.println();
        list.removeFirst();
        for (int item : list)
            System.out.print(item + " "); // 3 2 2 0 -4 -5

        System.out.println();
        list.removeLast();
        for (int item : list)
            System.out.print(item + " "); // 3 2 2 0 -4

        System.out.println();
        list.remove(0);
        list.add(4);
        for (int item : list)
            System.out.print(item + " "); // 4 3 2 2 -4
    }
}
