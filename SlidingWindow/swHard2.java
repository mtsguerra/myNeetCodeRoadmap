import java.util.*;

class swHard2 {
    /**
     * My first solution revolves around using a Deque, where it keeps track
     * of the Highest element on the current window and the next ones (in
     * this case only the next one, as if one is smaller than the current
     * biggest, it will only be added at the end of the deque only if it is
     * bigger than the next element on the deque) and by iterating throughout
     * the array I add the biggest element of the deque to the final array
     * that I will return of size (n - k + 1)
     * @param nums Initial array of nums to look
     * @param k Size of the window
     * @return The max number of each window that can be formed 
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k +1) q.removeFirst();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.removeLast();
            q.addLast(i);
            if (i >= k-1) ans[i - k + 1] = nums[q.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        swHard2 s = new swHard2();
        int[] ans = s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ans));
    }
}

// Other solutions can be made by, for example,
// 1. Instead of using a Deque using a size 2 array and keep track of the
// first as the biggest in the current window and the second one as the next
// biggest