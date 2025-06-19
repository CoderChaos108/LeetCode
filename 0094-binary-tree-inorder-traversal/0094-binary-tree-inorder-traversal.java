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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(st.size()>0){
            TreeNode node=st.peek();
            if(node==null){
                st.pop();
                if(st.size()==0)
                return list;
                node=st.peek();
                list.add(node.val);
                st.pop();
                st.push(node.right);   
            }
            else{
                st.push(node.left);
            }
        }
        return list;
    }
}