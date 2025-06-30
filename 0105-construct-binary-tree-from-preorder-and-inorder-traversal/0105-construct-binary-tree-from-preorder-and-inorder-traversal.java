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
    int p;
    void build(TreeNode node,List<Integer> list,int[] preorder){
        if(list.size()!=0){
            int i=0;
            while(list.get(i)!=node.val)
            i++;
            List<Integer> pre=list.subList(0,i);
            List<Integer> post=list.subList(i+1,list.size());
            TreeNode l=null;
            TreeNode r=null;
            boolean lnfound=true;
            boolean rnfound=true;
            if(pre.size()!=0){
            l=new TreeNode(preorder[p]);
            p++;
            node.left=l;
            build(l,pre,preorder);
            }
            if(post.size()!=0){
                r=new TreeNode(preorder[p]);
                p++;
                node.right=r;
            build(r,post,preorder);
            }
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        p=1;
        TreeNode root=new TreeNode(preorder[0]);
        List<Integer> ino=new ArrayList<>();
        for(int k:inorder)
        ino.add(k);
        build(root,ino,preorder);
        return root;

    }
}