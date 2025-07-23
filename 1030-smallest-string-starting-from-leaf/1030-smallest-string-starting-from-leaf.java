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
    HashSet<TreeNode> set=new HashSet<>(); 
    public void dfs(TreeNode node,TreeNode parent){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null)
        set.add(node);
        hm.put(node,parent);
        dfs(node.left,node);
        dfs(node.right,node);
    }
    public String smallestFromLeaf(TreeNode root) {
        hm=new HashMap<>();
        dfs(root,null);
        StringBuilder sb=new StringBuilder();
        while(set.size()!=0){
            int min=25;
            for(TreeNode node:set){
                if(node==null)
                return sb.toString();
                min=Math.min(min,node.val);
            }
            sb.append((char)('a'+min));
            HashSet<TreeNode> holder=new HashSet<>();
            for(TreeNode node:set){
                if(node.val==min)
                holder.add(hm.get(node));
            }
            set=new HashSet<>(holder);
        }
        return sb.toString();
    }
}