package chapter_01;

import java.util.Scanner;
import java.util.Stack;

/**
 * Represents an integer evaluator of postfix expressions. Assumes
 * the operands are constants.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class PostfixEvaluator
{
    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';
    private Stack<Integer> stack;

    /**
     * Sets up this evaluator by creating a new stack.
     */
    public PostfixEvaluator()
    {
        stack = new Stack<Integer>();
    }

    /**
     * Evaluates the specified postfix expression. If an operand is
     * encountered, it is pushed onto the stack. If an operator is
     * encountered, two operands are popped, the operation is
     * evaluated, and the result is pushed onto the stack.
     *
     * @param expr string representation of a postfix expression
     * @return value of the given expression
     */
    public int evaluate(String expr) throws Exception
    {
        int op1 = 0, op2 = 0, result = 0;
        String token;
        Scanner parser = new Scanner(expr);
        while (parser.hasNext())
        {
            token = parser.next();
            if (isOperator(token))
            {
                try 
                {
                    op2 = stack.pop();
                    op1 = stack.pop();
                }
                catch (Exception e)
                {
                    System.out.println("Reconstruct your expression");
                }
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(result);
            }
            else
                stack.push(Integer.parseInt(token));
        }
        return result;
    }

    /**
     * Determines if the specified token is an operator.
     *
     * @param token the token to be evaluated
     * @return true if token is operator
     */
    private boolean isOperator(String token)
    {
        return (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/"));
    }

    /**
     * Peforms integer evaluation on a single expression consisting of
     * the specified operator and operands.
     *
     * @param operation operation to be performed
     * @param op1       the first operand
     * @param op2       the second operand
     * @return value of the expression
     */
    private int evaluateSingleOperator(char operation, int op1, int op2) throws Exception
    {
        int result;
        switch (operation)
        {
            case ADD:
                result = op1 + op2;
                break;
            case SUBTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                result = op1 / op2;
            default:
                throw new Exception(operation + " is not a valid operation");
        }
        return result;
    }
}
