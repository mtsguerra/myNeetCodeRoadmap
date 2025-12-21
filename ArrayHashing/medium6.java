import java.util.*;

class medium6{
    /**
     * myFirst solution, using a hash set to store the numbers in the array.
     * For each number, if its the start of a sequence (using num-1 check),
     * we count the length of the sequence by checking for consecutive numbers
     * in the set. We keep track of the maximum length found.
     * @param nums input array
     * @return length of the longest consecutive elements sequence
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) set.add(num);
        for (int num : set) {
            if (set.contains(num-1)) continue;
            int count = 1;
            while (set.contains(++num)) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    // Other solutions can be made by, for example,
    // 1. Sorting the array and then iterating through it to find the longest
    //    consecutive sequence, but this would have a higher time complexity.
    // 2. Using a union-find data structure to group consecutive numbers
    //    together and then finding the size of the largest group.
}