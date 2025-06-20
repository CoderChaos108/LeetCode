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
        list.add(node.val);
        recur(node.left,list);
        recur(node.right,list);
        return list;
    }
    public void flatten(TreeNode root) {
        List<Integer> temp=new ArrayList<>();
        List<Integer> ans=new ArrayList<>(recur(root,temp));
        TreeNode node=root;
        for(int i=1;i<ans.size();i++){
            node.right=new TreeNode(ans.get(i));
            node.left=null;
            node=node.right;
        }
    }
}