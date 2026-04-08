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
    public static void preorder(TreeNode root,List<TreeNode> result){
        if(root==null) return;
        result.add(root);
        preorder(root.left,result);
        preorder(root.right,result);
    }
    public void flatten(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        preorder(root,result);
        for(int i=1;i<result.size();i++){
            root.right = result.get(i);
            root.left = null;
            root=root.right; 
        }
    }
}