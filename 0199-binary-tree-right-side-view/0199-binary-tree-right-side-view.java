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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
        return list;
        Deque<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int l=q.size()-1;
            for(int i=0;i<=l;i++){
                TreeNode node=q.poll();
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
                if(i==l)
                list.add(node.val);
            }
        }
        return list;
    }
}