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
    int val;
    public TreeNode build(TreeNode node){
        if(node==null)
        return null;
        TreeNode child;
        node.left=build(node.left);
        node.right=build(node.right);
        if(node.left==null&&node.right==null&&node.val==val){
            node=null;
            return node;
        }
        return node;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        val=target;
        return build(root);
    }
}