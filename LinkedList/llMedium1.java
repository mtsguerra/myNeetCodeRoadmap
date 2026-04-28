import java.util.*;

class llMedium1 {
    /**
     * <strong>LeetCode #143: Reorder List</strong>
     *
     * <p>
     *     Approach: First start by finding the middle of the list (using
     *     Slow&Fast pointers). Then, invert the second half and merge it
     *     with the first half.
     * </p>
     *
     * <pre>
     *     Complexity:
     *     -Time: O(n), finding the middle takes O(n/2), reversing the second half takes O(n/2), merging it takes O(n/2), resulting in approx O(n)
     *     -Space: O(1)
     * </pre>
     *
     * @param head the head of the linked list
     * @see
     * <a href="https://leetcode.com/problems/reorder-list/">LeetCode 143</a>
     */
    public void reorderList(ListNode head) {
        if  (head == null || head.next == null) return;
        ListNode secondHalf  = head;
        ListNode firstHalf  = head;
        while (secondHalf != null && secondHalf.next != null) {
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next.next;
        }
        secondHalf = reverseList(firstHalf.next);
        firstHalf.next = null;
        firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}