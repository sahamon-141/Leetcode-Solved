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
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ListNode curr = head;
        Stack<Integer> st = new Stack<>();
        while(current!=null){
            st.push(current.val);
            current = current.next;
        }
        while(curr!=null){
            int c = st.pop();
            if(curr.val!=c){
                return false;
            }
            curr = curr.next;
        }
        return true;

    }
}