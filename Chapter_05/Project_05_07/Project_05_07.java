package chapter_05;

/**
 * PP 5.7 Implement the deque from Programming Project 5.6 using links.
 * (Hint: Each node will need a next reference and a previous
 * reference.)
 *
 * @author Sharaf Qeshta
 * */
public class Project_05_07
{
    public static void main(String[] args)
    {
        LinkedDeque<String> linkedDeque = new LinkedDeque<>();
        linkedDeque.pushFront("USA");
        linkedDeque.pushBack("China");
        linkedDeque.pushFront("Uk");
        linkedDeque.pushFront("Germany");
        linkedDeque.pushBack("Russia");

        System.out.println(linkedDeque.popBack()); // Russia
        System.out.println(linkedDeque.popFront()); // Germany

        System.out.println(linkedDeque.front()); // UK
        System.out.println(linkedDeque.back()); // China
        System.out.println(linkedDeque.size()); // 3
        System.out.println(linkedDeque.isEmpty()); // false
    }
}
