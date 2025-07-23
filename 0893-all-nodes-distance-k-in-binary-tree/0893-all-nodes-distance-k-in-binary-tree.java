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
    HashMap<TreeNode,List<TreeNode>> hm;
    TreeNode t;
    List<Integer> ans;
    HashSet<TreeNode> set;
    int k;
    public void dfs(TreeNode node,TreeNode parent){
        if(node==null)
        return;
        List<TreeNode> list=new ArrayList<>();
        list.add(parent);
        list.add(node.left);
        list.add(node.right);
        hm.put(node,list);
        dfs(node.left,node);
        dfs(node.right,node);
    }
    public void build(TreeNode node,int d){
        if(node==null||set.contains(node)||d>k)
        return;
        set.add(node);
        if(d==k){
            ans.add(node.val);
            return;
        }
        for(TreeNode n:hm.get(node)){
            build(n,d+1);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int find) {
        hm=new HashMap<>();
        t=target;       
        k=find;
        ans=new ArrayList<>();
        set=new HashSet<>();
        dfs(root,null);
        build(t,0);
        return ans;
    }
}