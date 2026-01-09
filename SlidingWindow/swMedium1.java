import java.util.*;

class swMedium1 {
    /**
     * My first solution using sliding window and a hash set. Using a sliding
     * window that has two pointers, representing the start and the end of
     * the current substring without repeating characters, using a hash set
     * to keep track of the characters present on the current substring, and
     * in the case of finding a repeating character, I can move the start of
     * this substring until the repeating character is removed from the set.
     * @param s input string
     * @return length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        int lenMax = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                right++;
            }
            else {
                lenMax = Math.max(lenMax, right - left);
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                right++;
            }
        }
        return Math.max(lenMax, right - left);
    }
}

// Other solutions can be made by, for example,
// 1. Using a hash map to store the last seen index of each character,
//    allowing for faster updates of the left pointer when a duplicate is found.
// 2. Using an array of fixed size (e.g., 128 for ASCII) to track character presence,
//    which can be more space-efficient than a hash set for certain character sets