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
    public static List<Integer> inorder(TreeNode node,List<Integer> list){
        if(node==null)
        return list;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
        return list;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans=new ArrayList<>();
        return inorder(root,ans).get(k-1);

    }
}