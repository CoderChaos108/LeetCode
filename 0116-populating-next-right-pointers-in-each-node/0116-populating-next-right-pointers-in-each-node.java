/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        List<Node> list=new ArrayList<>();
        if(root==null)
        return root;
        int x=0;
        list.add(root);
        root.next=null;
        while(true){
            int t=list.size()-1;
            while(x<=t){
                if(list.get(x).left!=null)
                list.add(list.get(x).left);
                if(list.get(x).right!=null)
                list.add(list.get(x).right);
                if(x<t)
                list.get(x).next=list.get(x+1);
                x++;
            }
            if(x>list.size()-1)
            return root;
        }
    }
}