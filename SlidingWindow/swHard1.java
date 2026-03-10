import java.util.*;

class swHard1 {

    /**
     * My first solution using sliding window and two hash maps to count the
     * occurrences of all the characters in t and the current window in s.
     * While keeping track of how many key characters I have completed in the
     * current window, when getting to the point of having all the key
     * characters, I can try to move the left pointer to reduce the size of
     * the window until I have enough key characters, storing if necessary
     * the indexes of the smallest window so far, and then I can move the
     * right pointer to keep looking for more windows that may be smaller
     * than the current smallest window.
     * @param s input string
     * @param t string containing the characters that need to be present in the window
     * @return the smallest window in s that contains all the characters in
     * t, or an empty string if no such window exists
     */
    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) return "";
        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> countW = new HashMap<>();
        for (char c : t.toCharArray()) countT.put(c, countT.getOrDefault(c, 0) + 1);
        int have = 0, need = countT.size();
        int[] indxs = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            countW.put(c, countW.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && countW.get(c).equals(countT.get(c))) {
                have++;
            }
            while (have == need) {
                if (right - left + 1 < resLen) {
                    indxs[0] = left;
                    indxs[1] = right;
                    resLen = right - left + 1;
                }
                char leftC = s.charAt(left);
                countW.put(leftC, countW.get(leftC) - 1);
                if (countT.containsKey(leftC) && countW.get(leftC) < countT.get(leftC)) {
                    have--;
                }
                left++;
            }
        }
        return indxs[0] == -1 ? "" : s.substring(indxs[0], indxs[1] + 1);
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] count = new int[128];
        for (char c : t.toCharArray()) count[c]++;
        int left = 0, right = 0;
        int[] currentCount = new int[128];
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            currentCount[c]++;
            if (containsAll(count, currentCount)) {
                while(containsAll(count, currentCount)) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                    currentCount[s.charAt(left)]--;
                    left++;
                    }
                }
            right++;
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minLeft + minLen);
    }
    private boolean containsAll(int[] count, int[] currentCount) {
        for (int i = 0; i < count.length; i++) {
            if (currentCount[i] < count[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        swHard1 sol = new swHard1();
        String s = "abc";
        String t = "b";
        System.out.println(sol.minWindow(s, t)); // "BANC"
    }
}

// Other solutions can be made by, for example,
// 1. Using a single array to count the difference in occurrences between t
// and the current window in s, which can be more space-efficient and may
// allow for faster updates when moving the window.
// 2. Using a priority queue to keep track of the characters in the current
// window and their counts, which can allow for faster updates when moving
// the window and checking if the current window contains all the characters
// in t.