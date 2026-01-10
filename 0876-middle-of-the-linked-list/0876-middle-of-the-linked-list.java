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
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current.next!=null){
            current = current.next;
            length++;
        }
        int col = 0;
        if(length%2==0){
            col = (length/2);
        }
        else{
            col = length/2+1;
        }
        ListNode newhead = head;
        for(int i=0;i<col;i++){
            newhead=newhead.next;
        }
        return newhead;
    }
}