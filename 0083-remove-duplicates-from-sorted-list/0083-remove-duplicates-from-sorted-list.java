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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode dum = new ListNode(0);
        ListNode newhead = dum;
        HashSet<Integer> st = new HashSet<>();
        while(current!=null){
            
            if(!st.contains(current.val)){
                st.add(current.val);
                dum.next = current;
                dum = dum.next;
            }
            current = current.next;
        }
        dum.next = null;
        return newhead.next;
        
    }
}