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
    int ans=0;
    long target;
    public void dfs(TreeNode node,List<Long> list){
        if(node==null)
        return;
        long val=node.val;
        for(int i=0;i<list.size();i++){
            list.set(i,list.get(i)+val);
            if(list.get(i)==target){
                ans++;
            }
        }
        if(val==target)
        ans++;
        list.add((long)node.val);
        dfs(node.left,list);
        list.remove(list.size()-1);
        list.add((long)node.val);
        dfs(node.right,list);
        list.remove(list.size()-1);
        for(int i=0;i<list.size();i++){
            list.set(i,list.get(i)-val);
        }
    }
    public int pathSum(TreeNode root,int targetSum){
        target=targetSum;
        dfs(root,new ArrayList<>());
        return ans;
    }
}
