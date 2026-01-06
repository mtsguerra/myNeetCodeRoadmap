import java.util.*;

class StackMedium4 {
    /**
     * myFirst solution, using a stack to keep track of the indices of the bars.
     * We iterate through the heights array, and for each bar, we pop from the stack
     * until we find a bar that is shorter than the current one. For each popped bar,
     * we calculate the area of the rectangle that can be formed with that bar
     * as the shortest bar. We keep track of the maximum area found during this process.
     * @param heights array representing the heights of the bars
     * @return the area of the largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i= 0; i< heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}

// Other solutions can be made by, for example,
// 1. Using an array to simulate the stack for better performance.
// 2. Using a divide-and-conquer approach to find the largest rectangle.