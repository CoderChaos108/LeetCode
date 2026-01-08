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
    int sum=0;
    boolean second=false;
    public int dfs(TreeNode node){
        if(node==null)
        return 0;
        if(!second)
        sum=sum+node.val;
        int t=node.val+dfs(node.left)+dfs(node.right);
        long split=sum-t;
        split=split*t;
        if(second){
            ans=Math.max(ans,split);
        }
        return t;
    }
    long ans=0;
    public int maxProduct(TreeNode root) {
        dfs(root);
        second=true;
        dfs(root);
        return (int)(ans%1000000007);
    }
}