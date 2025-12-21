import java.util.*;

class StackMedium1 {
    /**
     * myFirst solution, using two stacks: one for all elements and another
     * to keep track of the minimum elements. When pushing, we add to the
     * minStack if the new element is smaller or equal to the current minimum.
     * When popping, we also pop from the minStack if the popped element is
     * the current minimum. This allows O(1) retrieval of the minimum element.
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    //public MinStack() {
    //    stack = new Stack<>();
    //    minStack = new Stack<>();
    //}

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}