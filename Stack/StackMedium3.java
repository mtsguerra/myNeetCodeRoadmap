import java.util.*;

class StackMedium3 {
    /**
     * myFirst solution, using a stack to keep track of temperatures and their indices.
     * We iterate through the temperatures array from the end to the beginning. For each temperature,
     * we pop elements from the stack until we find a warmer temperature or the stack is empty.
     * If the stack is empty, it means there are no warmer temperatures ahead, so we set the result for that day to 0.
     * Otherwise, we calculate the difference in indices to find out how many days until a warmer temperature.
     * Finally, we push the current temperature and its index onto the stack.
     * @param temperatures array of daily temperatures
     * @return array where each element represents the number of days until a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // [temp, index]
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[temperatures.length-1], temperatures.length-1});
        int[] result = new int[temperatures.length];
        result[temperatures.length-1] = 0;
        for (int i = temperatures.length-2; i >= 0; i--) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] <= currentTemp) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{currentTemp, i});
        }
        return result;
    }
}

// Other solutions can be made by, for example,
// 1. Using an array to simulate the stack for better performance.
// 2. Using a Deque instead of Stack for stack operations.
