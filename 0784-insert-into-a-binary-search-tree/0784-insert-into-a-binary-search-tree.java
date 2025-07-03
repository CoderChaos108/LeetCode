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
    List<Integer> list;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
        return new TreeNode(val);
        list=new ArrayList<>();
        inorder(root);
        for(int i=0;i<list.size();i++){
            if(list.get(list.size()-1)<=val){
            list.add(val);
            break;
            }
            if(i==0&&list.get(i)>=val){
            list.add(0,val);
            break;
            }
            else{
                if(list.get(i)>=val&&list.get(i-1)<=val){
                    list.add(i,val);
                    break;
                }
            }
        }
            return build(0,list.size()-1);
    }
    public TreeNode build(int l,int r){
        if(l>r)
        return null;
        int m=(l+r)/2;
        TreeNode node=new TreeNode(list.get(m));
        node.left=build(l,m-1);
        node.right=build(m+1,r);
        return node;
    }
    public void inorder(TreeNode node){
        if(node!=null){
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
    }
}