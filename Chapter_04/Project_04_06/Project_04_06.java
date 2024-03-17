package chapter_04;

import java.io.FileNotFoundException;

/**
 * PP 4.6 Complete the solution to the iterative maze solver so that your
 * solution marks the successful path.
 *
 * @author Sharaf Qeshta
 * */
public class Project_04_06
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Maze labyrinth = new Maze("maze.txt");

        System.out.println(labyrinth);

        MazeSolver solver = new MazeSolver(labyrinth);

        if (solver.markPath())
            System.out.println("The maze was successfully traversed!");
        else
            System.out.println("There is no possible path.");
        System.out.println(labyrinth);
    }
}
