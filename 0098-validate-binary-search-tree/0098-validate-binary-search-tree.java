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
    List<Integer> list;
    public void inorder(TreeNode node){
        if(node==null)
        return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
    public boolean isValidBST(TreeNode root) {
        list=new ArrayList<>();
        inorder(root);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1))
            return false;
        }
        return true;
    }
}