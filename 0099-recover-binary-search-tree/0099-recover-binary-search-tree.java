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
    public List<TreeNode> inorder(TreeNode node,List<TreeNode> list){
        if(node==null)
        return list;
        inorder(node.left,list);
        list.add(node);
        inorder(node.right,list);
        return list;
    }
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        List<TreeNode> temp=new ArrayList<>();
        List<TreeNode> list=new ArrayList<>(inorder(root,temp)); 
        int[] a=new int[list.size()];
        for(int i=0;i<a.length;i++){
            a[i]=list.get(i).val;
        }
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            list.get(i).val=a[i];
        }
    }
}