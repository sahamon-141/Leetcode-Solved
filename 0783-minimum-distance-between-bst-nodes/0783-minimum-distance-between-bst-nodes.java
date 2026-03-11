/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // Process current node
                if (prev != null)
                    minDiff = Math.min(minDiff, curr.val - prev);
                prev = curr.val;
                curr = curr.right;
            } else {
                // Find inorder predecessor
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr)
                    predecessor = predecessor.right;

                if (predecessor.right == null) {
                    // Make thread and go left
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    // Remove thread, process node
                    predecessor.right = null;
                    if (prev != null)
                        minDiff = Math.min(minDiff, curr.val - prev);
                    prev = curr.val;
                    curr = curr.right;
                }
            }
        }
        return minDiff;
    }
}