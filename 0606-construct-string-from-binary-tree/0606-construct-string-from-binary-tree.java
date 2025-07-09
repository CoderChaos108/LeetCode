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
    public String build(TreeNode node){
        if(node==null)
        return "";
        StringBuilder sb=new StringBuilder();
        sb.append(String.valueOf(node.val));
        if(node.left==null&&node.right==null)
        return sb.toString();
        else{
            sb.append("("+build(node.left)+")");
            if(node.right!=null){
                sb.append("("+build(node.right)+")");
            }
        }
        return sb.toString();
    }
    public String tree2str(TreeNode root) {
        return build(root);
    }
}