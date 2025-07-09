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
    List<TreeNode> list;
    public void inorder(TreeNode node){
        if(node==null)
        return;
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }
    public TreeNode convertBST(TreeNode root) {
        list=new ArrayList<>();
        inorder(root);
        int s=0;
        for(int i=list.size()-1;i>=0;i--){
            s=s+list.get(i).val;
            list.get(i).val=s;
        }
        return root;
    }
}