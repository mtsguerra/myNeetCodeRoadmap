import java.util.*;

class medium1 {
    /**
     * myFirst solution, using a hash map and a string key based on the
     * counting of characters in each string to group anagrams together.
     * @param strs input array of strings
     * @return list of groups of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int n : count) {
                key.append('#');
                key.append(n);
            }
            String keyStr = key.toString();
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
    // Other solutions can be made by, for example,
    // 1. Sorting each string and using the sorted string as a key in the map.
    // 2. Using a prime number multiplication approach to create a unique key
    //    for each group of anagrams.
    // 3. Using a Trie data structure to group anagrams together.
    // 4. Using brute force comparison of each string with every other string.
}