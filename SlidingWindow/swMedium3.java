import java.util.*;

class swMedium3 {
    /**
     * My first solution using sliding window and two arrays to count the
     * occurrences of each character in s1 and the current window in s2. I
     * keep track of the index of the last character in s1, so I can check it
     * first, to make it less likely to do the more expensive check of
     * comparing the two arrays, and if the counts of this character match,
     * then I can compare the two arrays to check if the current window is a
     * permutation of s1. If it is not, I can move the window by one
     * character to the right and repeat the process until I have checked
     * all possible windows of the same length as s1 in s2.
     * @param s1 the string of which we want to find a permutation in s2
     * @param s2 the string in which we want to find a permutation of s1
     * @return true if s2 contains a permutation of s1, false otherwise
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        if (len1 > s2.length()) return false;
        int[] count1 = new int[26];
        int testIndex = 0;
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            testIndex = s1.charAt(i) - 'a';
        }
        int left = 0, right = len1;
        int[] currentPermutation = new int[26];
        for (int i = 0; i < right; i++) {
            currentPermutation[s2.charAt(i) - 'a']++;
        }
        while (right < s2.length()) {
            if (currentPermutation[testIndex] == count1[testIndex] && Arrays.equals(count1,
                    currentPermutation)) return true;
            currentPermutation[s2.charAt(left) - 'a']--;
            currentPermutation[s2.charAt(right) - 'a']++;
            left++;
            right++;
        }
        return Arrays.equals(count1, currentPermutation);
    }

    public static void main(String[] args) {
        swMedium3 sol = new swMedium3();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(sol.checkInclusion(s1, s2)); // true
    }
}

// Other solutions can be made by, for example,
// 1. Using a hash map to count the occurrences of each character, which can
// be more flexible for larger character sets.
// 2. Using a single array to count the difference in occurrences between s1
// and the current window in s2, which can be more space-efficient and may
// allow for faster updates when moving the window.