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
    public TreeNode prune(TreeNode node){
        if(node==null)
        return null;
            node.left=prune(node.left);
            node.right=prune(node.right);
            if(node.val==1)
            return node;
            else{
                if(node.left==null&&node.right==null)
                return null;
                return node;
            }
    }
    public TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }
}