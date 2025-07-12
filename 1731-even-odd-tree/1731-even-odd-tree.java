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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int d=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean even=true;
            if(d%2!=0)
            even=false;
            int v=Integer.MAX_VALUE;
            if(even)
            v=0;
                for(int i=0;i<size;i++){
                    TreeNode node=q.poll();
                    int val=node.val;
                    if(even){
                        if(val%2==0||val<=v)
                        return false;
                    }
                    else{
                        if(val%2!=0||val>=v)
                        return false;
                    }
                    if(node.left!=null)
                    q.add(node.left);
                    if(node.right!=null)
                    q.add(node.right);
                    v=val;
            }
            d++;
        }
        return true;
    }
}