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
    public TreeNode build(int west,int east,int[] nums){
        if(west>east)
        return null;
        int n=west+(east-west)/2;
        TreeNode node=new TreeNode(nums[n]);
        node.left=build(west,n-1,nums);
        node.right=build(n+1,east,nums);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(0,nums.length-1,nums);
    }
}