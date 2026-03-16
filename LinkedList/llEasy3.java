import java.util.*;

class llEasy3 {
    /**
     * My first solution, using a tortoise and hare logic to try to find a
     * cycle. Where the hare jumps 2 node at each time, so if there is a
     * cycle the hare will reach the tortoise at some point or reach the end.
     * @param head head of the linked list
     * @return boolean cycle
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