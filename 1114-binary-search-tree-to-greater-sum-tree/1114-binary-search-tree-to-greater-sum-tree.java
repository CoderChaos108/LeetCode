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
    public int sum(TreeNode node,int s){
        if(node==null)
        return s;
        s=sum(node.right,s);
        s=s+node.val;
        node.val=s;
        s=sum(node.left,s);
        return s;
    }
    public TreeNode bstToGst(TreeNode root) {
        sum(root,0);
        return root;
    }
}