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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean nulled=false;
        while(!q.isEmpty()){
            int size=q.size();
             for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node==null){
                    nulled=true;
                }
                else{
                    if(nulled)
                    return false;
                    q.add(node.left);
                    q.add(node.right);
                }
             }
        }
        return true;
    }
}             