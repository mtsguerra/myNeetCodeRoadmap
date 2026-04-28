import java.util.*;

class llMedium2 {
    /**
     * LeetCode #19: Remove Nth Node From End of List
     *
     * <p>
     *     Approach: start by creating a dummy node to iterate through the
     *     linkedlist to get its size. After, iterate using a previous and
     *     current node, until found the (size-n)-th node and remove it by
     *     using {@code prev.next=curr.next}
     * </p>
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