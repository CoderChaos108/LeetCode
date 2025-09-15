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
    List<List<Integer>> ans=new ArrayList<>();
    int target;
    public void dfs(List<Integer> list,TreeNode node,int sum){
        if(node==null)
        return;
        int val=node.val;
        sum=sum+val;
        list.add(val);
        if(sum==target&&node.left==null&&node.right==null){
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        dfs(list,node.left,sum);
        dfs(list,node.right,sum);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target=targetSum;
        dfs(new ArrayList<>(),root,0);
        return ans;
    }
}