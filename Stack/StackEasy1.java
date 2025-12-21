import java.util.Stack;

class StackEasy1 {
    /**
     * myFirst solution, using a stack to track opening brackets. For each
     * closing bracket, we check if it matches the top of the stack. If not,
     * we return false. At the end, if the stack is empty, all brackets
     * were matched correctly.
     * @param s input string containing brackets
     * @return true if the string is valid, false otherwise
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c){
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    // Other solutions can be made by, for example,
    // 1. Using a HashMap to map opening brackets to closing brackets
    //    and checking accordingly.
    // 2. Using an array as a stack for better performance.
}