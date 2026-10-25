/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
public String serialize(TreeNode root) {
        if (root == null) return "null";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if (curr == null) {
                sb.append("null ");
                continue;
            }
            
            sb.append(curr.val).append(" ");
            q.offer(curr.left);
            q.offer(curr.right);
        }
        
        return sb.toString().trim();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("null") || data.length() == 0) return null;
        int n = data.length();
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int i=1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()&&i<n){
            TreeNode curr = q.poll();
            if(!nodes[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.left);
            }
            i++;
            if(i<n && !nodes[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.right);
            }
            i++;

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));