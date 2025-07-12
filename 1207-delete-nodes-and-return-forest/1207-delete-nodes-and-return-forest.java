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
    HashSet<Integer> set;
    List<TreeNode> list;
    public TreeNode forest(TreeNode node,boolean orphan){
        if(node==null)
        return null;
        int val=node.val;
        boolean dead=false;
        if(set.contains(val))
        dead=true;
        if(orphan&&!dead)
        list.add(node);
        node.left=forest(node.left,dead);
        node.right=forest(node.right,dead);
        if(dead)
        return null;
        return node;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set=new HashSet<>();
        for(int i:to_delete)
        set.add(i);
        list=new ArrayList<>();
        forest(root,true);
        return list;
    }
}