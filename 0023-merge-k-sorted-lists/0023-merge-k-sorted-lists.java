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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode temp = null;

    // Custom Comparator for the min-heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a.val,b.val)
            );
    for(ListNode node:lists){
        if(node!=null){
            pq.offer(node);
        }
    }


    while(!pq.isEmpty()){
        ListNode curr = pq.poll();

        if(head==null){
            head = curr;
            temp = curr;
        }
        else{
            temp.next = curr;
            temp = curr;
        }
        if(curr.next!=null){
            pq.offer(curr.next);
        }
    }
    return head;
        

    }
}