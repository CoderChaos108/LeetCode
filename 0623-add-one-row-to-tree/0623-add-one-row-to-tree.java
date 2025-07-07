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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> q=new LinkedList<>();
        if(depth==1){
            TreeNode neoRoot=new TreeNode(val);
            neoRoot.left=root;
            return neoRoot;
        }
        int d=1;
        q.add(root);
        while(d!=depth||q.size()!=0){
            int size=q.size();
            if(d==depth-1){
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                TreeNode left=node.left;
                TreeNode right=node.right;
                TreeNode neoleft=new TreeNode(val);
                TreeNode neoright=new TreeNode(val);
                node.left=neoleft;
                node.right=neoright;
                neoleft.left=left;
                neoright.right=right;
            }
            break;
            }
            else{
                for(int i=0;i<size;i++){
                    TreeNode node=q.poll();
                    if(node.left!=null)
                    q.add(node.left);
                    if(node.right!=null)
                    q.add(node.right);
                }
            }
            d++;
        }
        return root;
    }
}