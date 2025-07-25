class Solution {
    HashMap<Integer,Integer>hm=new HashMap<>();
    int[] a;
    int p;
    public TreeNode build(int l,int r){
        if(l>r||p<0)
        return null;
        int i=hm.get(a[p]);
        TreeNode node=new TreeNode(a[p]);
        p--;
        node.right=build(i+1,r);
        node.left=build(l,i-1);
        return node;
    }
    public TreeNode buildTree(int[] inorder,int[] postorder){
        a=postorder;
        for(int i=0;i<inorder.length;i++)hm.put(inorder[i],i);
        p=a.length-1;
        return build(0,a.length-1);
    }
}
