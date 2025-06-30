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
            List<Integer> pre=new ArrayList<>();
            List<Integer> post=new ArrayList<>();
            TreeNode l=null;
            TreeNode r=null;
            boolean lnfound=true;
            boolean rnfound=true;
            for(int j=0;j<i;j++){
                pre.add(list.get(j));
                if(list.get(j)==preorder[p]&&lnfound){
                l=new TreeNode(list.get(j));
                node.left=l;
                p++;
                lnfound=false;
                }
            }
            if(!lnfound)
            build(l,pre,preorder);
            for(int j=i+1;j<list.size();j++){
            post.add(list.get(j));
            if(list.get(j)==preorder[p]&&rnfound){
                r=new TreeNode(list.get(j));
                node.right=r;
                p++;
                rnfound=false;
            }
            }
            if(!rnfound)
            build(r,post,preorder);
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