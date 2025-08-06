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
    List<List<String>> list=new ArrayList<>();
    public int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public List<List<String>> printTree(TreeNode root) {
     int h=height(root);
     int len=(int)Math.pow(2,h)-1;
    for(int i=0;i<h;i++){
        List<String> l=new ArrayList<>();
        for(int j=0;j<len;j++)
        l.add("");
        list.add(l);
    }
    Queue<TreeNode> q=new LinkedList<>();
    Queue<Integer> col=new LinkedList<>();
    q.add(root);
    col.add((len-1)/2);
    int t=0;
    while(!q.isEmpty()){
        int size=q.size();
        List<String> l=list.get(t);
        t++;
        int nextCol=(int)Math.pow(2,h-t-1);
        for(int i=0;i<size;i++){
            int c=col.poll();
            TreeNode node=q.poll();
            l.set(c, String.valueOf(node.val));
            if(node.left!=null){
                q.add(node.left);
                col.add(c-nextCol);
            }
            if(node.right!=null){
                q.add(node.right);
                col.add(c+nextCol);
            }
        }
    }
    return list;
    }
}