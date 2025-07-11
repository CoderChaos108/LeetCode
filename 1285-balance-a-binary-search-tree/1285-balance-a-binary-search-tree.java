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
    public TreeNode build(List<Integer> list,int l,int r){
        if(l>r)
        return null;
        int m=(l+r)/2;
        TreeNode node=new TreeNode(list.get(m));
        node.left=build(list,l,m-1);
        node.right=build(list,m+1,r);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        list=new ArrayList<>();
        inorder(root);
        return build(list,0,list.size()-1);
    }
}