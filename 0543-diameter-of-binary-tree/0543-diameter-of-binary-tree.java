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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public int diam(TreeNode root){
        if(root==null) return 0;
        int left_ht = height(root.left);
        int right_ht = height(root.right);
        int left_diam = diam(root.left);
        int right_diam = diam(root.right);
        return Math.max(Math.max(left_diam,right_diam),left_ht+right_ht);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diam(root);
    }
}