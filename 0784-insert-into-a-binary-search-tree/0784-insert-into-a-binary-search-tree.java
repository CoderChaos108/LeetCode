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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=new TreeNode(val);
        if(root==null)
        return node;
        TreeNode current=root;
        while(true){
            if(current.val>val){
                if(current.left==null){
                    current.left=node;
                    return root;
                }
                else{
                    current=current.left;
                }
            }
            else{
                if(current.right==null){
                    current.right=node;
                    return root;
                }
                current=current.right;
            }
        }
    }
}