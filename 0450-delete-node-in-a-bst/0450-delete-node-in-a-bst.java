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
    public List<Integer> inorder(TreeNode node,List<Integer> list){
        if(node!=null){
            inorder(node.left,list);
            list.add(node.val);
            inorder(node.right,list);
            return list;
        }
        else
        return list;
    }

    public TreeNode build(int l,int r,List<Integer> list){
        if(l>r)
        return null;
        int m=(l+r)/2;
        TreeNode newNode=new TreeNode(list.get(m));
        newNode.left=build(l,m-1,list);
        newNode.right=build(m+1,r,list);
        return newNode;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        return null;
        if(root.val==key){
            List<Integer> list=new ArrayList<>();
            inorder(root,list);
            list.remove((Integer)key);
            return build(0,list.size()-1,list);
        }
        TreeNode node=root;
        while(true){
            TreeNode temp=null;
            if(node.val>key)
            temp=node.left;
            if(node.val<key)
            temp=node.right;
            if(temp==null)
            return root;
            if(temp.val==key){
                List<Integer> list=new ArrayList<>();
                inorder(temp,list);
                list.remove((Integer)key);
                TreeNode builtNode=build(0,list.size()-1,list);
                if(temp==node.left)
                node.left=builtNode;
                else
                node.right=builtNode;
                return root;   
            }
            node=temp;
        }
    }
}
