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
    public static List<Integer> inorder(TreeNode node,List<Integer> list,int k){
        if(node==null)
        return list;
        inorder(node.left,list,k);
        list.add(node.val);
        if(list.size()==k)
        return list;
        inorder(node.right,list,k);
        return list;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> l=new ArrayList<>(inorder(root,ans,k));
        return l.get(k-1);
    }
}