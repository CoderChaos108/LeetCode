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
    public List<Integer> inorder(TreeNode node,List<Integer> list){
        if(node==null)
        return list;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
        return list;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        inorder(root1,l1);
        inorder(root2,l2);
        List<Integer> ans=new ArrayList<>();
        int p=0;
        int q=0;
        int s1=l1.size();
        int s2=l2.size();
        while(p<s1||q<s2){
            if(p>=s1&&q<s2){
                ans.add(l2.get(q));
                q++;
            }
            else if(p<s1&&q>=s2){
                ans.add(l1.get(p));
                p++;
            }
            else{
                int a=l1.get(p);
                int b=l2.get(q);
                if(a<=b){
                    ans.add(a);
                    p++;
                }
                else{
                    ans.add(b);
                    q++;
                }
            }
        }
        return ans;
    }
}