/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode n1,n2;
    public TreeNode LCA(TreeNode node){
        if(node==null||node==n1||node==n2)
        return node;
        TreeNode left=LCA(node.left);
        TreeNode right=LCA(node.right);
        if(left!=null&&right!=null)
        return node;
        if(left==null)
        return right;
        else
        return left;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     n1=p;
     n2=q;
     return LCA(root);   
    }
}