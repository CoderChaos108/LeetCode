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
    public int sum(TreeNode node,int n){
        n=n*10+node.val;
        if(node.left==null&node.right==null)
        return n;
        if(node.left==null&&node.right!=null)
        return sum(node.right,n);
        if(node.left!=null&&node.right==null)
        return sum(node.left,n);
        return sum(node.left,n)+sum(node.right,n);
    }
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
}