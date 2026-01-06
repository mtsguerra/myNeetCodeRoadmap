import java.util.*;

class tpMedium2 {
    /**
     * My first solution, using sorting and two pointers. when sorted, I can
     * iterate through the array skipping any duplicates, and if I get to a
     * positive number, I can break the loop as no three numbers can sum to
     * zero. For each number, I set two pointers, one at the next index and
     * another at the end of the array, and calculate the sum of the three
     * numbers. As for I am skipping duplicates, I don't need to worry about
     * getting duplicate triplets.
     * @param nums input array
     * @return list of lists containing unique triplets that sum to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return res;
    }
}

// Other solutions can be made by, for example,
// 1. Using a hash set to store pairs of numbers and checking for the third number
//    that would complete the triplet to sum to zero.
// 2. Using a brute-force approach with three nested loops to check all possible
//    triplets, but this would have a higher time complexity.