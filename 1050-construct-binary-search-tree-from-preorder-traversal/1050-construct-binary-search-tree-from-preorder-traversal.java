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
    public TreeNode build(int l,int r,int[] preorder){
        if(l>r)
        return null;
        TreeNode node=new TreeNode(preorder[l]);
        int v=node.val;
        int m=l+1;
        while(m<preorder.length&&v>preorder[m])
        m++;
        node.left=build(l+1,m-1,preorder);
        node.right=build(m,r,preorder);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(0,preorder.length-1,preorder);
    }
}