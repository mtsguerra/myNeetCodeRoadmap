import java.util.*;

class swMedium2 {
    /**
     * My first solution using sliding window and an array to count the
     * occurrences of each character. While expanding the right pointer, I
     * keep track of the most frequent character in the current sequence, and
     * also keeping track of how many character I would need to change to
     * make it all the same. If the number of character I need to change is
     * greater than k, I try moving the left pointer to reduce the number of
     * characters to change until it is less than or equal to k, and then I
     * can update the maximum sequence length.
     * @param s input string
     * @param k maximum number of characters that can be changed
     * @return length of the longest substring that can be made the same by
     * changing at most k characters
     */
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxSeq = 0;
        int[] count = new int[26];
        int maxApp = 0;
        while (right < s.length()) {
            maxApp = Math.max(maxApp, ++count[s.charAt(right)-'A']);
            if ((right - left + 1) - maxApp > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxSeq = Math.max(maxSeq, (right - left + 1));
            right++;
        }
        return maxSeq;
    }
}

// Other solutions can be made by, for example,
// 1. Using a hash map to count the occurrences of each character, which can
// be more flexible for larger character sets.
// 2. Using a binary search approach to find the longest valid substring
// length, although this may be less efficient than the sliding window
// approach for this problem.