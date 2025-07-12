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
    public int dif(TreeNode node,int max,int min){
        if(node==null)
        return 0;
        int val=node.val;
        int d=Math.max(max-val,val-min);
        max=Math.max(max,val);
        min=Math.min(min,val);
        int temp=Math.max(dif(node.left,max,min),dif(node.right,max,min));
        return Math.max(d,temp);
    }
    public int maxAncestorDiff(TreeNode root) {
        return dif(root,-1,Integer.MAX_VALUE);
    }
}