/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        return ans;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int l=q.size();
            for(int i=0;i<l;i++){
                Node node=q.poll();
                list.add(node.val);
                for(Node listnode:node.children)
                q.add(listnode);
            }
            ans.add(list);
        }
        return ans;
    }
}