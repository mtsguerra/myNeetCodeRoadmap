import java.util.*;

class llMedium2 {
    /**
     * <LeetCode ex19>
     *
     * My first solution, first I create a dummy node to iterate to get the
     * size of the linkedlist. After having the size, iterate using a previous
     * and current node, when found the node to eliminate (size-i) do it by
     * having previous.next = current.next.
     * @param head the starting of the linkedlist
     * @param n the Nth element to remove from the end
     * @return the linkedlist with the element removed
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if  (head == null || head.next == null) return null;
        int size = 0;
        ListNode dummy = head;
        while (dummy != null) {
            size++;
            dummy = dummy.next;
        }
        ListNode crr = head;
        ListNode prev = null;
        int i=0;
        while (crr != null){
            if (size-i==n){
                if (prev == null){
                    head = head.next;
                }
                else prev.next = crr.next;
            }
            else{
                prev = crr;
                crr = crr.next;
            }
            i++;
        }
        return head;
    }
}