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
    public boolean check(TreeNode a,TreeNode b){
        if(a==null&&b!=null||a!=null&&b==null)
        return false;
        if(a==null&&b==null)
        return true;
        if(a.val!=b.val)
        return false;
        if(a.left!=null&&a.right!=null){
            if(b.left==null||b.right==null)
            return false;
        }
        if(b.left!=null&&b.right!=null){
            if(a.left==null||a.right==null)
            return false;
        }
        if(a.left==null&&a.right!=null||a.left!=null&&a.right==null){
            if(b.left==null&&b.right==null||b.left!=null&&b.right!=null)
            return false;
        }
        if(b.left==null&&b.right!=null||b.left!=null&&b.right==null){
            if(a.left==null&&a.right==null||a.left!=null&&a.right!=null)
            return false;
        }
        if(a.left!=null&&b.left!=null&&a.right!=null&&b.right!=null){
            TreeNode al=a.left;
            TreeNode ar=a.right;
            TreeNode bl;
            TreeNode br;
            if(al.val==b.left.val&&ar.val==b.right.val){
                bl=b.left;
                br=b.right;
            }
            else if(al.val==b.right.val&&ar.val==b.left.val){
                bl=b.right;
                br=b.left;
            }
            else
            return false;
            return check(al,bl)&&check(ar,br);
        }
        else{
            TreeNode n1;
            if(a.left==null)
            n1=a.right;
            else
            n1=a.left;
            TreeNode n2;
            if(b.right==null)
            n2=b.left;
            else
            n2=b.right;
            return check(n1,n2);
        }
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1,root2);
    }
}