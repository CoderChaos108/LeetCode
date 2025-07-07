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
    public TreeNode reverseOddLevels(TreeNode root) {
        int d=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            int size=q.size();
            boolean odd=(d%2!=0);
            List<TreeNode> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(odd)
                list.add(node);
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
            }
            if(odd){
                int s=(list.size())/2;
                int t=list.size()-1;
                for(int j=0;j<s;j++){
                    TreeNode n1=list.get(j);
                    TreeNode n2=list.get(t-j);
                    int temp=n2.val;
                    n2.val=n1.val;
                    n1.val=temp;
                }
            }
            d++;
        }
        return root;
    }
}