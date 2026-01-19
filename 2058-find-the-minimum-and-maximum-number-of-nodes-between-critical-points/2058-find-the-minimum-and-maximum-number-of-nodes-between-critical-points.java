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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Need at least 3 nodes to have a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        List<Integer> criticalIndices = new ArrayList<>();
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // Current node index (starting from 1 for second node)
        
        while (curr.next != null) {
            ListNode next = curr.next;
            
            // Check if current node is a critical point
            if ((curr.val > prev.val && curr.val > next.val) ||  // local maxima
                (curr.val < prev.val && curr.val < next.val)) { // local minima
                criticalIndices.add(index);
            }
            
            // Move pointers
            prev = curr;
            curr = next;
            index++;
        }
        
        // If we have fewer than 2 critical points
        if (criticalIndices.size() < 2) {
            return new int[]{-1, -1};
        }
    
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = criticalIndices.get(criticalIndices.size() - 1) - criticalIndices.get(0);
        
        for (int i = 1; i < criticalIndices.size(); i++) {
            int diff = criticalIndices.get(i) - criticalIndices.get(i - 1);
            if (diff < minDistance) {
                minDistance = diff;
            }
        }
        
        return new int[]{minDistance, maxDistance};

    }
}