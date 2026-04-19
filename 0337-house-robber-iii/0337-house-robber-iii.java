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
    TreeNode yes=new TreeNode(1);
    HashMap<List<TreeNode>,Integer> dp=new HashMap<>();
    public int robber(TreeNode node,boolean lastRobbed){
        if(node==null)
        return 0;
        TreeNode last=null;
        if(lastRobbed)
        last=yes;
        List<TreeNode> pair=Arrays.asList(node,last);
        if(dp.containsKey(pair))
        return dp.get(pair);
        int cash=0;
        if(lastRobbed){
            cash=robber(node.left,false)+robber(node.right,false);
        }
        else{
            int take=node.val+robber(node.left,true)+robber(node.right,true);
            int skip=robber(node.left,false)+robber(node.right,false);
            cash=Math.max(take,skip);
        }
        dp.put(pair,cash);
        return cash;
    }
    public int rob(TreeNode root) {
        return robber(root,false);
    }
}