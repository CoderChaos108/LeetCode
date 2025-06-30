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
    void build(TreeNode node, List<Integer> inorder, int[] preorder) {
    if (inorder.size() == 0) return;

    int index = inorder.indexOf(node.val);
    List<Integer> leftInorder = inorder.subList(0, index);
    List<Integer> rightInorder = inorder.subList(index + 1, inorder.size());

    if (!leftInorder.isEmpty()) {
        TreeNode left = new TreeNode(preorder[p++]);
        node.left = left;
        build(left, leftInorder, preorder);
    }

    if (!rightInorder.isEmpty()) {
        TreeNode right = new TreeNode(preorder[p++]);
        node.right = right;
        build(right, rightInorder, preorder);
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