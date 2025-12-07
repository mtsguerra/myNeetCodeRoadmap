import java.util.*;

class easy3 {
    /**
     * myFirst solution, using a hash map to store already seen numbers and
     * their indexes, then for each number checks if the complement was
     * already seen before to return the indexes.
     * @param nums input array
     * @param target target sum
     * @return indexes of the two numbers that add up to target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        easy3 obj = new easy3();
        int[] nums = {3,3};
        int target = 6;
        int[] result = obj.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }

    // Other solutions can be made by, for example,
    // 1. Using a brute-force approach with two nested loops to check all pairs.
    // 2. Sorting the array and using a two-pointer technique to find the
    // pair, but doing this way would require having a separate structure to
    // store the original indexes.
}