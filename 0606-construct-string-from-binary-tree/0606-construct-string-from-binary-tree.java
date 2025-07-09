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
        sb.append("("+build(node.left)+")");
        sb.append("("+build(node.right)+")");
        if(sb.charAt(sb.length()-2)=='('){
            sb.setLength(sb.length()-2);
        }
        if(sb.charAt(sb.length()-2)=='('){
            sb.setLength(sb.length()-2);
        }
        return sb.toString();
    }
    public String tree2str(TreeNode root) {
        return build(root);
    }
}