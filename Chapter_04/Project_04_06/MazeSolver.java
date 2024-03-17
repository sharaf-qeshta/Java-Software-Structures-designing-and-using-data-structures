package chapter_04;


import java.util.Deque;
import java.util.LinkedList;
/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class MazeSolver
{
    private final Maze maze;

    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }

    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse()
    {
        boolean done = false;
        int row, column;
        Position pos = new Position();
        Deque<Position> stack = new LinkedList<>();
        stack.push(pos);
        while (!(done) && !stack.isEmpty())
        {
            pos = stack.pop();
            maze.tryPosition(pos.getX(),pos.getY()); // this cell has been tried
            if (pos.getX() == maze.getRows()-1 && pos.getY() == maze.getColumns()-1)
                done = true;
            else
            {
                push_new_pos(pos.getX() - 1,pos.getY(), stack);
                push_new_pos(pos.getX() + 1,pos.getY(), stack);
                push_new_pos(pos.getX(),pos.getY() - 1, stack);
                push_new_pos(pos.getX(),pos.getY() + 1, stack);
            }
        }

        return done;
    }

    public boolean markPath()
    {
        return  markPath(0, 0);
    }

    public boolean markPath(int row, int column)
    {
        boolean done = false;
        if (maze.validPosition(row, column))
        {
            maze.tryPosition(row, column);
            if (row == maze.getRows()-1 && column == maze.getColumns()-1)
                done = true;
            else
            {
                if (!done)
                    done = markPath(row-1, column);
                if (!done)
                    done = markPath(row, column-1);
                if (!done)
                    done = markPath(row+1, column);
                if (!done)
                    done = markPath(row, column+1);
            }
            if (done)
                maze.markPath(row, column);
        }
        return done;
    }

    /**
     * Push a new attempted move onto the stack
     * @param x represents x coordinate
     * @param y represents y coordinate
     * @param stack the working stack of moves within the grid
     * @return stack of moves within the grid
     */
    private void push_new_pos(int x, int y,
                              Deque<Position> stack)
    {
        Position npos = new Position();
        npos.setX(x);
        npos.setY(y);
        if (maze.validPosition(x,y))
            stack.push(npos);
    }
}
