class Solution {
    HashMap<TreeNode,TreeNode> hm;
    HashSet<TreeNode> set;
    List<Integer> ans;
    TreeNode t;
    int k;
    
    public void dfs(TreeNode node,TreeNode parent){
        if(node==null)return;
        if(parent!=null)hm.put(node,parent);
        dfs(node.left,node);
        dfs(node.right,node);
    }
    
    public void build(TreeNode node,int d){
        if(node==null||set.contains(node))
        return;
        set.add(node);
        if(d==k){
            ans.add(node.val);
            return;
        }
        build(node.left,d+1);
        build(node.right,d+1);
        build(hm.get(node),d+1);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int find) {
        hm=new HashMap<>();
        set=new HashSet<>();
        ans=new ArrayList<>();
        t=target;
        k=find;
        dfs(root,null);
        build(t,0);
        return ans;
    }
}
