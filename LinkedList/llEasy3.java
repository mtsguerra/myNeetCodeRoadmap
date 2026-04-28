import java.util.*;

class llEasy3 {
    /**
     * <strong>LeetCode ex141. Linked List Cycle</strong>
     *
     * <p>Approach: Using the Floyd’s Cycle-Finding Algorithm (tortoise and
     * hare logic) to find the cycle.</p>
     * <p>The tortoise and hare logic revolves around having two
     * pointers, one that moves 1 node at a time (tortoise), and another
     * moving 2 (hare).If there is a cycle they are bounded to find each
     * other at some point.</p>
     *
     * <pre>
     * Complexity:
     * - Time: O(n), n being the number of nodes
     * - Space: O(1), as no extra structures are used
     * </pre>
     *
     * @param head the head of the linked list
     * @return {@code true} if a cycle is found
     * @see <a href="https://leetcode.com/problems/linked-list-cycle/">LeetCode 141</a>
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