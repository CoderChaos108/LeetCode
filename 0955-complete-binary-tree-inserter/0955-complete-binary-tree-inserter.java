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
class CBTInserter {
    Queue<TreeNode> q;
    TreeNode root;
    TreeNode node;
    public CBTInserter(TreeNode r) {
        root=r;
        q=new LinkedList<>();
        node=null;
        q.add(root);
        while(node==null||node.left!=null&&node.right!=null){
            int size=q.size();
            for(int i=0;i<size;i++){
                node=q.poll();
                if(node.left==null)
                break;
                else
                q.add(node.left);
                if(node.right==null)
                break;
                else
                q.add(node.right);
            }   
        }
    }
    
    public int insert(int val) {
        int n=node.val;
        if(node.left==null){
            node.left=new TreeNode(val);
            q.add(node.left);
        }
        else{
            node.right=new TreeNode(val);
            q.add(node.right);
            node=q.poll();          
        }
        return n;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */