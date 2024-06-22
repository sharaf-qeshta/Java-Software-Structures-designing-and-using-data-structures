package chapter_06;

/**
 * PP 6.6 Implement an OrderedList using a LinkedList object to store
 * the list elements.
 *
 * @author Sharaf Qeshta
 * */
public class Project_06_06
{
    public static void main(String[] args) throws ElementNotFoundException {
        OrderedList<Integer> list = new OrderedList<>();
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
