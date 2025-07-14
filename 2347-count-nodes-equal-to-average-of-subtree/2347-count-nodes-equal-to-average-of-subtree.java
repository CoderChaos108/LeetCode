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
    public int[] avg(TreeNode node){
        if(node==null){
            return new int[2];
        }
        int[] left=avg(node.left);
        int[] right=avg(node.right);
        int localC=left[1]+right[1]+1;
        int localSum=left[0]+right[0]+node.val;
        if(node.val==(localSum/localC))
        c++;
        left[0]=localSum;
        left[1]=localC;
        return left;
    }
    public int averageOfSubtree(TreeNode root) {
        c=0;
        avg(root);
        return c;
    }
}