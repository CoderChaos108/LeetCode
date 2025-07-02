class Solution {
    TreeNode a;
    TreeNode b;

    public List<TreeNode> inorder(TreeNode node,List<TreeNode> list){
        if(node==null)
        return list;
        inorder(node.left,list);
        list.add(node);
        inorder(node.right,list);
        return list;
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        inorder(root,list);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).val>list.get(i+1).val){
                if(a==null)
                a=list.get(i);
                b=list.get(i+1);
            }
        }
        int k=a.val;
        a.val=b.val;
        b.val=k;
    }
}
