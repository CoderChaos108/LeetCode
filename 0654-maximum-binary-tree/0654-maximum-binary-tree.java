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
    public static TreeNode build(int west,int east,TreeNode node,int[] a){
        if(west>east)
        return null;
        int l=west;
        for(int i=west+1;i<=east;i++){
            if(a[l]<a[i])
            l=i;
        }
        TreeNode newNode=new TreeNode(a[l]);
        newNode.left=build(west,l-1,newNode,a);
        newNode.right=build(l+1,east,newNode,a);
        return newNode;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(0,nums.length-1,null,nums);
    }
}