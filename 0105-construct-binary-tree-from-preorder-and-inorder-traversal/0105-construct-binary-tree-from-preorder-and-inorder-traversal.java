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
    HashMap<Integer,Integer> hm;
    void build(TreeNode node,int west,int east,int[] preorder){
        if(west!=east){
            int i=hm.get(node.val);
            if(west!=i){
            TreeNode l=new TreeNode(preorder[p]);
            p++;
            node.left=l;
            build(l,west,i-1,preorder);
            }
            if(east!=i){
                TreeNode r=new TreeNode(preorder[p]);
                p++;
                node.right=r;
            build(r,i+1,east,preorder);
            }
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        p=1;
        hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        hm.put(inorder[i],i);
        TreeNode root=new TreeNode(preorder[0]);
        List<Integer> ino=new ArrayList<>();
        for(int k:inorder)
        ino.add(k);
        build(root,0,preorder.length-1,preorder);
        return root;
    }
}