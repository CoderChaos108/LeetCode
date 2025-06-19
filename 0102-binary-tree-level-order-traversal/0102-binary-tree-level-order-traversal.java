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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        return ans;
        list.add(root);
        List<Integer> listTemp=new ArrayList<>();
        listTemp.add(root.val);
        ans.add(listTemp);
        int x=0;
        while(true){
            List<Integer> temp=new ArrayList<>();
            int t=list.size()-1;
            while(x<=t){
            if(list.get(x).left!=null){
            temp.add(list.get(x).left.val);
            list.add(list.get(x).left);
            }
            if(list.get(x).right!=null){
            temp.add(list.get(x).right.val);
            list.add(list.get(x).right);
            }
            x++;            
            }
            if(x>=list.size())
            return ans;        
            ans.add(temp);
        }
    }
}