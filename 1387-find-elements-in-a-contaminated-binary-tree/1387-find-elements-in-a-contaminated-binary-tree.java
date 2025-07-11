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
class FindElements {
    HashSet<Integer> set;
    public void recover(TreeNode node){
        if(node==null)
        return;
        int x=node.val;
        set.add(x);
        if(node.left!=null){
            node.left.val=2*x+1;
            recover(node.left);
        }
        if(node.right!=null){
            node.right.val=2*x+2;
            recover(node.right);
        }
    }   
    public FindElements(TreeNode root) {
        set=new HashSet<>();
        root.val=0;
        recover(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */