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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        // push all nodes into stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // make the last node as new head of the linked list
        if (!stack.isEmpty()) {
            head = stack.pop();
            temp = head;

            // pop all the nodes and append to the linked list
            while (!stack.isEmpty()) {
                
                // append the top value of stack in list
                temp.next = stack.pop();

                temp = temp.next;
            }

            // update the next pointer of last node to null
            temp.next = null;
        }

        return head;
        }
    }
