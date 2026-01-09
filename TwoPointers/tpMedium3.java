import java.util.*;

class tpMedium3 {
    /**
     * myFirst solution, using two pointers to find the maximum area of water
     * that can be contained between the lines represented by the heights
     * in the array. To find it I only need to calculate the area formed by
     * the lines moving the pointer of the smaller height inward
     * @param height array representing the heights of the lines
     * @return the maximum area of water that can be contained
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

// Other solutions can be made by, for example,
// 1. Brute force approach by checking all possible pairs of lines
//    and calculating the area for each pair, but this would have a
//    higher time complexity.
// 2. Using a mathematical approach to derive a formula for the maximum
//    area based on the heights and positions of the lines, but this
//    would be more complex and less intuitive.