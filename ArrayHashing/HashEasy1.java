import java.util.*;

class HashEasy1 {
    /**
     * First solution; uses the method add of HashSet which returns false if
     * the element is on the set already, so it can be used for both adding
     * the number and checking for duplicates in one step.
     *
     * @param nums array of integers
     * @return true if any value appears at least twice in the array, and false
     *         if every element is distinct
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if (!set.add(num)) return true;
        }
        return false;
    }

    // Others solutions can be made by, for example,
    // 1. Sorting the array and checking for adjacent equal elements.
    // 2. Using a HashMap to count occurrences of each element.
    // 3. Using a boolean array if the range of numbers is known and limited.
    // 4. Using Java Streams to check for duplicates.
    // 5. Using HashSet, but checking contains() before adding or even
    // checking for the size of the set after adding all elements.
}