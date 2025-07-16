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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> children=new HashSet<>();
        HashMap<Integer,TreeNode> hm=new HashMap<>();
        for(int i=0;i<descriptions.length;i++){
            int val=descriptions[i][0];
            int childVal=descriptions[i][1];
            children.add(childVal);
            boolean left=descriptions[i][2]==1;
            TreeNode node;
            if(!hm.containsKey(val)){
                node=new TreeNode(val);
                hm.put(val,node);
            }
            else
            node=hm.get(val);
            TreeNode child;
            if(!hm.containsKey(childVal)){
                child=new TreeNode(childVal);
                hm.put(childVal,child);
            }
            else
            child=hm.get(childVal);
            if(left)
            node.left=child;
            else
            node.right=child;
        }
        TreeNode root=null;
        for(int i:hm.keySet()){
            if(!children.contains(i)){
                root=hm.get(i);
                break;
            }
        }
        return root;
    }
}