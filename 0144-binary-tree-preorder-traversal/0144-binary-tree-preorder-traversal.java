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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)
        return list;
        st.push(root);
        while(st.size()!=0){
            TreeNode node=st.peek();
            if(node==null){
                st.pop();
                if(st.size()==0)
                return list;
                node=st.peek();
                st.pop();
                st.push(node.right);
            }
            else{
                list.add(node.val);
                st.push(node.left);
            }
        }
        return list;
    }
}