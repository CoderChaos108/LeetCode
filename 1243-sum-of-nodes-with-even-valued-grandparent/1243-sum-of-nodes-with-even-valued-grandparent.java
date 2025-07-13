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
    public void sum(TreeNode node,boolean grandParent,boolean parent){
        if(node==null)
        return;
        if(grandParent)
        s=s+node.val;
        boolean even=node.val%2==0;
        sum(node.left,parent,even);
        sum(node.right,parent,even);
    }
    public int sumEvenGrandparent(TreeNode root) {
        s=0;
        sum(root,false,false);
        return s;
    }
}