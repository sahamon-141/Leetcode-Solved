/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(first!=null&&first.next!=null){
            second = second.next;
            first = first.next.next;
            
            if(first==second){
                return true;
            }
        }
        return false;
    }
}