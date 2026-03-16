import java.util.*;

class llEasy1 {
    class Solution {
        /**
         * My first solution using two nodes, one to keep track of the
         * current node while iterating throughout the list and another one
         * for the last node seen, and while iterating through the list I can
         * reverse every pointer to the previous node. Returning at the end
         * the new head and former tail of the list.
         * @param head
         * @return
         */
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
}