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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
        return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        list.add(root.val);
        while(!q.isEmpty()){
            int l=q.size();
            int largest=Integer.MIN_VALUE;
            boolean child=false;
            for(int i=0;i<l;i++){            
                TreeNode node=q.poll();
                if(node.left!=null){
                child=true;    
                q.add(node.left);
                if(node.left.val>largest)
                largest=node.left.val;
                }
                if(node.right!=null){
                child=true;
                q.add(node.right);
                if(node.right.val>largest)
                largest=node.right.val;
                }
            }
            if(child)
            list.add(largest);
        }
        return list;
    }
}