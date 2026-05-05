/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        int k_actual = k % len;
        if (k_actual == 0) return head;

        int pos = len - k_actual;

        ListNode newTail = head;
        for (int i = 1; i < pos; i++) {
            newTail = newTail.next;
        }

        ListNode result = newTail.next;
        newTail.next = null;
        tail.next = head;

        return result;
    }
}