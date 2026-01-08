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
    HashMap<TreeNode,Integer> hm=new HashMap<>();
    public int dfs(TreeNode node){
        if(node==null)
        return 0;
        sum=sum+node.val;
        hm.put(node,node.val+dfs(node.left)+dfs(node.right));
        return hm.get(node);
    }
    long ans=0;
    public void dfs2(TreeNode node){
        if(node==null)
        return;
        long part1=hm.get(node);
        long part2=sum-hm.get(node);
        long split=part1*part2;
        ans=Math.max(ans,split);
        dfs2(node.left);
        dfs2(node.right);
    }
    public int maxProduct(TreeNode root) {
        dfs(root);
        dfs2(root);
        return (int)(ans%1000000007);
    }
}