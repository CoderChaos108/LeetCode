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
    HashMap<Integer,Integer> hm;
    public int sumf(TreeNode node){
        if(node==null)
        return 0;
        int lf=sumf(node.left);
        int rf=sumf(node.right);
        int s=node.val+lf+rf;
        hm.put(s,hm.getOrDefault(s,0)+1);
        return s;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        hm=new HashMap<>();
        sumf(root);
        int l=0;
        for(int i:hm.keySet()){
            l=Math.max(l,hm.get(i));
        }
        int n=0;
        for(int i:hm.keySet()){
            if(hm.get(i)==l)
            n++;
        }
        int[] a=new int[n];
        int x=0;
        for(int i:hm.keySet()){
            if(hm.get(i)==l){
                a[x]=i;
                x++;
            }
        }
        return a;
    }
}