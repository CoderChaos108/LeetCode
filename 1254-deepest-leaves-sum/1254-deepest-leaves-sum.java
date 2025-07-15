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
    int s;
    int maxd;
    public void dfs(TreeNode node,int d){
        if(node==null)
        return;
        if(d==maxd){
            s=s+node.val;
        }
        else if(d>maxd){
            maxd=d;
            s=node.val;
        }
        dfs(node.left,d+1);
        dfs(node.right,d+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        s=0;
        maxd=0;
        dfs(root,0);
        return s;
    }
}