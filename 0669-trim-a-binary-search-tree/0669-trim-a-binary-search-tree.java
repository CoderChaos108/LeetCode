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
    int u,l;
    public TreeNode trim(TreeNode node){
        if(node==null)
        return null;
        int v=node.val;
        if(v<l){
            return trim(node.right);
        }
        else if(v>u)
        return trim(node.left);
        else{
            node.left=trim(node.left);
            node.right=trim(node.right);
            return node;
        }
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        l=low;
        u=high;
        return trim(root);
    }
}