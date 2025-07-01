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
    public void build(TreeNode node){
        if(node.val<val){
            TreeNode l=node.left;
            TreeNode r=node.right;
            node.right=null;
            node.left=new TreeNode(node.val);
            node.val=val;
            node.left.left=l;
            node.left.right=r;
        }
        else{
            if(node.right!=null){
                build(node.right);
            }
            else{
                node.right=new TreeNode(val);
            }
        }
    }
    public TreeNode insertIntoMaxTree(TreeNode root, int value) {
            val=value;
            build(root);
            return root;
    }
}