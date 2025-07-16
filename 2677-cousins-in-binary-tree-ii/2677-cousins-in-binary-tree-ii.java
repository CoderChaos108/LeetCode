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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int s=0;
            List<List<TreeNode>> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                List<TreeNode> list=new ArrayList<>();
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.add(node.left);
                    list.add(node.left);
                    s=s+node.left.val;
                }
                if(node.right!=null){
                    q.add(node.right);
                    list.add(node.right);
                    s=s+node.right.val;
                }
                level.add(list);
            }
            for(List<TreeNode> l:level){
                int bros=0;
                for(TreeNode i:l)
                bros=bros+i.val;
                for(TreeNode i:l)
                i.val=s-bros;
            }
        }
        root.val=0;
        return root;
    }
}