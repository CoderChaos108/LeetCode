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
        String s1=build(node.left);
        String s2=build(node.right);
        if(s1.length()==0&&s2.length()!=0){
            sb.append("()");
            sb.append("("+s2+")");
        }
        else{
            if(s1.length()!=0){
                sb.append("("+s1+")");
            }
            if(s2.length()!=0)
            sb.append("("+s2+")");
        }
        return sb.toString();
    }
    public String tree2str(TreeNode root) {
        return build(root);
    }
}