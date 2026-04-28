import java.util.*;

class llEasy3 {
    /**
     * <h1>LeetCode ex141. Linked List Cycle</h1>
     *
     * <h2>Approach: Using the tortoise and hare logic to find the cycle.</h2>
     * <p>The tortoise and hare logic revolves around having two
     * pointers, one that moves 1 node at a time (tortoise), and another
     * moving 2 (hare).If there is a cycle they are bounded to find each
     * other at some point.</p>
     *
     * <hr>
     *     <b>Complexity: </b> This algorithm has O(n) time complexity and O
     *     (1) space complexity
     *
     * @param head Head of the linked list
     * @return Boolean cycle
     */
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) return true;
        }
        return false;
    }
}