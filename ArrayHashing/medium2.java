import java.util.*;

class medium2 {
    /**
     * myFirst solution,using a map to count the occurrences of each number,
     * after getting the counts, using a priority queue to sort the numbers
     * based on their counts in descending order, and in the case of a tie,
     * using the number's value in ascending order. Finally, extracting the top k
     * frequent numbers from the priority queue and returning them in an array.
     * @param nums input array
     * @param k number of top frequent elements to return
     * @return array of the k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[k];
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        for (int i = 0; i<k;i++) {
            answer[i] = pq.poll()[0];
        }
        return answer;
    }
    // Other solutions can be made by, for example,
    // 1. Using a bucket sort approach where we create an array of lists
    //    indexed by frequency and then iterate from the highest frequency
    //    down to collect the top k elements.
    // 2. Using a max-heap to store all elements based on their frequency
    //    and then extracting the top k elements.
    // 3. Using a quickselect algorithm to partition the elements based on
    //    their frequency and find the top k elements in average linear time.
}