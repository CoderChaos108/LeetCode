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
class BSTIterator {
    public static List<Integer> inorder(TreeNode node,List<Integer> list){
        if(node==null)
        return list;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
        return list;
    }
    int small;
    List<Integer> treeList;
    int pointer;
    public BSTIterator(TreeNode root) {
        treeList=new ArrayList<>();
        inorder(root,treeList);
        small=treeList.get(0)-1;
        pointer=-1;
    }
    
    public int next() {
         return treeList.get(++pointer);
    }
    
    public boolean hasNext() {
        if(pointer==treeList.size()-1)
        return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */