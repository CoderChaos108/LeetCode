/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> preOrder=new ArrayList<>();
    public void dfs(TreeNode node){
        if(node==null)
        return;
        preOrder.add(node);
        dfs(node.left);
        dfs(node.right);
    }
    TreeNode n1,n2;
    boolean a,b=false;
    public boolean search(TreeNode node){
        if(node==null)
        return false;
        if(node==n1)
        a=true;
        if(node==n2)
        b=true;
        if(a&&b)
        return true;
        return search(node.left)||search(node.right);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        n1=p;
        n2=q;
        dfs(root);
        boolean foundP=false;
        boolean foundQ=false;
        int i=preOrder.size()-1;
        while(!foundP||!foundQ){
            TreeNode node=preOrder.get(i);
            if(node==p)
            foundP=true;
            if(node==q)
            foundQ=true;
            i--;
        }
        i++;
        for(int j=i;j>0;j--){
            if(search(preOrder.get(j)))
            return preOrder.get(j);
            a=false;
            b=false;
        }
        return root;
    }
}