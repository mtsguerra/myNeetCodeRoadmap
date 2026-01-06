import java.util.*;

class tpMedium1 {
    /**
     * myFirst solution, using two pointers to find the two numbers that add
     * up to the target, for already being sorted array. I can start with one
     * pointer at the beginning and another at the end of the array. I
     * calculate the sum of the numbers and if the sum is equal to the
     * target, I can already return the indices, if the sum is greater than
     * the target I can check for the possibility of not being able to find
     * the pair at all, in the case of the left pointer number times two
     * being greater than the target, as for the array being sorted, all
     * other sums will be greater too.
     * @param numbers input array of sorted integers
     * @param target the target sum
     * @return array containing the 1-based indices of the two numbers that add up to the target
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {-1, -1};
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            } else if (sum < target) left++;
            else{
                right--;
                if (numbers[left] * 2 > target) break;
            }
        }
        return ans;
    }
}

// Other solutions can be made by, for example,
// 1. Using a hash map to store the numbers and their indices,
//    then checking for each number if the complement (target - number)
//    exists in the map.
// 2. Using binary search for each number to find if the complement
//    exists in the array, taking advantage of the sorted property.