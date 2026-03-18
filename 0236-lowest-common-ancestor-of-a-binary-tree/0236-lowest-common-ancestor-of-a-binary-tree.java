/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static boolean getpath(TreeNode root,int x,List<TreeNode> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.val==x){
            return true;
        }
        boolean left = getpath(root.left,x,path);
        boolean right = getpath(root.right,x,path);
        if(left||right){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static TreeNode lca(TreeNode root,int n1,int n2){
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        getpath(root,n1,path1);
        getpath(root,n2,path2);
        int i=0;
        for(;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i).val!=path2.get(i).val){
                break;
            }
        }
        return  path1.get(i-1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p.val,q.val);
    }
}