import java.util.*;

class llEasy2 {
    /**
     * My first solution, using a dummy head to return at the end the start
     * of the new Linked list I can iterate throughout both of the list until
     * one of them is empty. Comparing both the values on the lists to add
     * the smallest to the new list.
     * @param list1 starting node of the list 1
     * @param list2 starting node of the list 2
     * @return next node to the dummy head (start of the new list)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode();
        ListNode dummy = head;

        while (list1 != null && list2 != null) {
            boolean l1Smaller = list1.val <= list2.val;
            ListNode temp = new ListNode(l1Smaller ? list1.val : list2.val);
            head.next = temp;
            head = head.next;
            if (l1Smaller) list1 = list1.next;
            else list2 = list2.next;
        }
        while (list1 != null) {
            ListNode temp = new ListNode(list1.val);
            head.next = temp;
            head = head.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode temp = new ListNode(list2.val);
            head.next = temp;
            head = head.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}