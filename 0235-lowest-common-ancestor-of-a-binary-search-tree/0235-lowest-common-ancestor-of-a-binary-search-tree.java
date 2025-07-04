/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current=root;
        int ps=p.val;
        int qs=q.val;
        while(true){
            if(current==p||current==q)
            return current;
            int cs=current.val;
            if((ps>cs&&qs<cs)||(ps<cs&&qs>cs))
            return current;
            if(p.val>current.val)
            current=current.right;
            else
            current=current.left;
        }
    }
}