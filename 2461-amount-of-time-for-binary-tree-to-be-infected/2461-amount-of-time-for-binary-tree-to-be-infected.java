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
    HashMap<TreeNode,TreeNode> hm;
    TreeNode patientZero;
    int start;
    int time;
    public void dfs(TreeNode node,TreeNode parent){
        if(node==null)
        return;
        if(node.val==start)
        patientZero=node;
        hm.put(node,parent);
        dfs(node.left,node);
        dfs(node.right,node);
    }
    public void infect(TreeNode node,int t){
        if(node==null||!hm.containsKey(node))
        return;
        TreeNode parent=hm.get(node);
        time=Math.max(time,t);
        hm.remove(node);
        infect(node.left,t+1);
        infect(node.right,t+1);
        infect(parent,t+1);
    }
    public int amountOfTime(TreeNode root, int s) {
        hm=new HashMap<>();
        start=s;
        time=0;
        dfs(root,null);
        infect(patientZero,0);
        return time;
    }
}