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
    HashSet<TreeNode> set;
    public TreeNode LCA(TreeNode node){
        if(node==null||set.contains(node))
        return node;
        TreeNode left=LCA(node.left);
        TreeNode right=LCA(node.right);
        if(left!=null&&right!=null)
        return node;
        if(left==null)
        return right;
        return left;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<TreeNode> list=new ArrayList<>();
            boolean children=false;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.add(node.left);
                    children=true;
                }
                if(node.right!=null){
                    q.add(node.right);
                    children=true;
                }
                list.add(node);
            }
            if(!children)
            set=new HashSet<>(list);
        }
        return LCA(root);
    }
}