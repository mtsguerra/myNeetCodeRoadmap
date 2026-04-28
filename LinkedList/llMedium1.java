import java.util.*;

class llMedium1 {
    /**
     * <h1>LeetCode #143: Reorder List</h1>
     *
     * <p>
     *     Approach: First start by finding the middle of the list (using
     *     Slow&Fast pointers). Then, invert the second half and merge it
     *     with the first half.
     * </p>
     * @param head Head of the linked list
     */
    public void reorderList(ListNode head) {
        if  (head == null || head.next == null) return;
        ListNode secondHalf  = head;
        ListNode firstHalf  = head;
        while (secondHalf != null && secondHalf.next != null) {
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next.next;
        }
        secondHalf = reverseList(secondHalf.next);
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