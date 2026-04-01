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
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr!=null){
            len++;
            curr = curr.next;
        }
        ListNode odd = head;
        Stack<ListNode> st = new Stack<>();
        while(odd!=null){
            st.push(odd);
            odd = odd.next;
        }
        ListNode even = head;

        ListNode dummy = new ListNode(-1);   
        ListNode result = dummy;
        for(int i=0;i<len;i++){
            if(i%2==0){
                dummy.next=even;
                even = even.next;
                dummy = dummy.next;
            }
            else{
                dummy.next=st.pop();
                dummy = dummy.next;
            }
        }
        dummy.next=null;
        
    }
}