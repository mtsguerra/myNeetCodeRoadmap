import java.util.*;

class StackMedium2 {
    /**
     * myFirst solution, using a stack to evaluate the RPN expression.
     * For each token, if it's a number, we push it onto the stack.
     * If it's an operator, we pop the top two numbers from the stack,
     * apply the operator, and push the result back onto the stack.
     * At the end, the stack will contain one element, which is the result.
     * @param tokens array of strings representing the RPN expression
     * @return the evaluated result as an integer
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int finalResult = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    // Other solutions can be made by, for example,
    // 1. Using an array as a stack for better performance.
    // 2. Using Deque instead of Stack for stack operations.
}