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
    TreeNode lca;
    TreeNode a;
    TreeNode b;
    public boolean findp(TreeNode n){
        if(n==null)
        return false;
        if(n==a)
        return true;
        return findp(n.left)||findp(n.right);
    }
    public boolean findq(TreeNode n){
        if(n==null)
        return false;
        if(n==b)
        return true;
        return findq(n.left)||findq(n.right);
    }
    public void ancestor(TreeNode node){
        if(node==null)
        return;
        if((findp(node)&findq(node)))
        lca=node;
        ancestor(node.left);
        ancestor(node.right);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        a=p;
        b=q;
        ancestor(root);
        return lca;
    }
}