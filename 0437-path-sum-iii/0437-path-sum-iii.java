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
        List<Long> newList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            newList.add(list.get(i)+val);
            if(newList.get(i)==target)
            ans++;
        }
        newList.add(val);
        if(val==target)
        ans++;
        dfs(node.left,newList);
        dfs(node.right,newList);
    }
    public int pathSum(TreeNode root,int targetSum){
        target=targetSum;
        dfs(root,new ArrayList<>());
        return ans;
    }
}
