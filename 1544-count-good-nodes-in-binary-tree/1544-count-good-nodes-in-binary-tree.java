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
    int c;
    public void count(TreeNode node,int current){
        if(node==null)
        return;
        int val=node.val;
        if(val>=current){
            c++;
            current=val;
        }
        count(node.left,current);
        count(node.right,current);
    }
    public int goodNodes(TreeNode root) {
        c=0;
        count(root,root.val-1);
        return c;
    }
}