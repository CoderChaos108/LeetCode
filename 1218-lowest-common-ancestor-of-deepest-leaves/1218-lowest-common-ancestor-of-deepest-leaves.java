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
    HashSet<TreeNode> set=new HashSet<>();
    int d=0;
    public void depth(TreeNode node,int d0){
        if(node==null){
            d=Math.max(d,d0);
            return;
        }
        depth(node.left,d0+1);
        depth(node.right,d0+1);
    }
    public void dfs(TreeNode node,int d1){
        if(node==null)
        return;
        if(node.left==null&&node.right==null&&d1==d)
        set.add(node);
        dfs(node.left,d1+1);
        dfs(node.right,d1+1);
    }
    public TreeNode LCA(TreeNode node){
        if(node==null||set.contains(node))
        return node;
        TreeNode left=LCA(node.left);
        TreeNode right=LCA(node.right);
        if(left!=null&&right!=null)
        return node;
        if(left==null)
        return right;
        return left;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);
        d--;
        dfs(root,0);
        return LCA(root);
    }
}