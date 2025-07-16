/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> hm;
    public Node clone(Node node){
        if(node==null)
        return node;
        if(hm.containsKey(node))
        return hm.get(node);
        Node neoNode=new Node(node.val);
        hm.put(node,neoNode);
        for(Node n:node.neighbors){
            neoNode.neighbors.add(clone(n));
        }
        return neoNode;
    }
    public Node cloneGraph(Node node) {
        hm=new HashMap<>();
        return clone(node);
    }
}