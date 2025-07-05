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
    int[] a;
    public List<TreeNode> build(int l,int r){
        List<TreeNode> ans=new ArrayList<>();
        if(l==r){
            ans.add(new TreeNode(a[l]));
            return ans;
        }
        for(TreeNode n:build(l+1,r)){
            TreeNode node=new TreeNode(a[l]);
            node.right=n;
            ans.add(node);
        }
        for(TreeNode n:build(l,r-1)){
            TreeNode node=new TreeNode(a[r]);
            node.left=n;
            ans.add(node);
        }
        for(int i=l+1;i<=r-1;i++){
            for(TreeNode left:build(l,i-1)){
                for(TreeNode right:build(i+1,r)){
                    TreeNode node=new TreeNode(a[i]);
                    node.left=left;
                    node.right=right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        a=new int[n];
        for(int i=0;i<a.length;i++)
        a[i]=i+1;
        return build(0,n-1);
    }
}