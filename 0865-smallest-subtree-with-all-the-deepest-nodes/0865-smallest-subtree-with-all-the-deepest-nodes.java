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
    int d=0;
    public void depth(TreeNode node,int d0){
        if(node==null){
            d=Math.max(d,d0);
            return;
        }
        depth(node.left,d0+1);
        depth(node.right,d0+1);
    }
    public TreeNode LCA(TreeNode node,int d1){
        if(node==null||(node.left==null&&node.right==null&&d==d1))
        return node;
        TreeNode left=LCA(node.left,d1+1);
        TreeNode right=LCA(node.right,d1+1);
        if(left!=null&&right!=null)
        return node;
        if(left==null)
        return right;
        return left;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root,0);
        d--;
        return LCA(root,0);
    }
}