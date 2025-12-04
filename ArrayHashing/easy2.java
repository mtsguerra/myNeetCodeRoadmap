class easy2 {

    /**
     * mySecond solution, using a single counting array to count the
     * occurrences on both strings at the same time, while one of them adds
     * to the count, the other decreases from it. At the end, is enough to
     * just check if all counts are zero or not.
     * @param s first string
     * @param t second string
     * @return true if t is an anagram of s, false otherwise
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int n : count) if (n != 0) return false;
        return true;
    }

        /**
         * myFirst solution; using two counting arrays to count the occurrences of
         * each character in both strings, but doing an optimized check while
         * counting the second string to return false as soon as a character
         * count exceeds the first string's count or if a character is found in the
         * second string that doesn't exist in the first string. Also keeping
         * track of the characters that have mismatched counts to avoid having to
         * do a full comparison at the end.
         * @param s first string
         * @param t second string
         * @return true if t is an anagram of s, false otherwise
         */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : s.toCharArray()) {
            count1[c - 'a']++;
        }
        boolean[] notEqual = new boolean[26];
        for (char c : t.toCharArray()) {
            if (count2[c - 'a']++ > count1[c - 'a']
                || count1[c - 'a'] == 0) {
                return false;
            }
            if (count2[c - 'a'] != count1[c - 'a']) {
                notEqual[c - 'a'] = true;
            }
            else if (count2[c - 'a'] == count1[c - 'a']) {
                notEqual[c - 'a'] = false;
            }
        }
        for (boolean b : notEqual) {
            if (b) return false;
        }
        return true;
    }

    // Other solutions can be made by, for example,
    // 1. Sorting both strings and comparing them.
    // 2. Using a single counting array and incrementing for the first string
    //    and decrementing for the second string, then checking if all counts
    //    are zero.
    // 3. Using a HashMap to count occurrences of each character.
    // 4. Using Java Streams to sort and compare the strings.
}