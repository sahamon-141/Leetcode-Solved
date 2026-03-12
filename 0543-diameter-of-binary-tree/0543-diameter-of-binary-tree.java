class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root)
     {
      calculateheight(root);
      return diameter;
      }

     public int calculateheight(TreeNode root)
      {
        if (root==null)
        {
            return 0;
        }
        int leftheight=calculateheight(root.left);
        int rightheight=calculateheight(root.right);
        diameter = Math.max(diameter,leftheight+rightheight);
         return 1+ Math.max(leftheight, rightheight);
             
    }
}