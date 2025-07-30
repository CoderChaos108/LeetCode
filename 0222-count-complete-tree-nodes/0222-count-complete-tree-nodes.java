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
    public int count(TreeNode node,int n){
        if(node==null)
        return n;
        n++;
        return n+count(node.left,0)+count(node.right,0);
    }
    public int countNodes(TreeNode root) {
        return count(root,0);
    }
}