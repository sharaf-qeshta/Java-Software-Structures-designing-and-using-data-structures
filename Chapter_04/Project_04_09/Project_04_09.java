package chapter_04;

import java.io.FileNotFoundException;

/**
 * PP 4.9 Modify the maze problem in this chapter so that it can start from
 * a user-defined starting position (other than 0, 0) and search for a
 * user-defined ending point (other than row-1, column-1).
 *
 * @author Sharaf Qeshta
 * */
public class Project_04_09
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Maze labyrinth = new Maze("maze.txt");

        System.out.println(labyrinth);

        MazeSolver solver = new MazeSolver(labyrinth);

        if (solver.markPath(0, 0, 8, 12))
            System.out.println("The maze was successfully traversed!");
        else
            System.out.println("There is no possible path.");
        System.out.println(labyrinth);
    }
}
