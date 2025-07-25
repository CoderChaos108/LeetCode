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
    public int dfs(TreeNode node,int depth){
        if(node==null)
        return depth-1;
        return Math.max(dfs(node.left,depth+1),dfs(node.right,depth+1));
    }
    public int maxDepth(TreeNode root) {
        return dfs(root,1);
    }
}