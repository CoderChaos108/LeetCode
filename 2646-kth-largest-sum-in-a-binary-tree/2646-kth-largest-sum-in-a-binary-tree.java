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
    List<Long> list;
    void insert(long val) {
    int index=Collections.binarySearch(list, val);
    if(index<0)
    index=-index-1;
    list.add(index,val);
}

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        list=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            long s=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                s=s+node.val;
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
            }
            insert(s);
        }
        if(list.size()<k)
        return -1;
        return list.get(list.size()-k);
    }
}