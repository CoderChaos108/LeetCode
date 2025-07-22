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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
        return "";
        q.add(root);
        sb.append(String.valueOf(root.val)+",");
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left==null)
                sb.append("#,");
                else{
                sb.append(String.valueOf(node.left.val)+",");
                q.add(node.left);
                }
                if(node.right==null)
                sb.append("#,");
                else{
                sb.append(String.valueOf(node.right.val)+",");
                q.add(node.right);
                }
            }
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
        return null;
        String[] s=data.split(",");
        Queue<TreeNode> q=new LinkedList<>();
        int c=1;
        TreeNode root=new TreeNode(Integer.valueOf(s[0]));
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(!s[c].equals("#")){
                TreeNode left=new TreeNode(Integer.valueOf(s[c]));
                q.add(left);
                node.left=left;
            }
            if(!s[c+1].equals("#")){
                TreeNode right=new TreeNode(Integer.valueOf(s[c+1]));
                q.add(right);
                node.right=right;
            }
            c=c+2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;