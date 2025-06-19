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
    public static List<Integer> recur(TreeNode node,List<Integer> list){
        if(node==null)
        return list;
            recur(node.left,list);
            recur(node.right,list);
            list.add(node.val);
        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        return recur(root,ans);
    }
}