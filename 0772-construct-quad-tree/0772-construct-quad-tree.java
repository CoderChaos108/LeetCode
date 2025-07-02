/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node build(int[][] m,int l,int r,int u,int d){
        if(l>=r||u>=d)
        return null;
        boolean leaf=true;
            for(int i=u;i<d;i++){
            for(int j=l;j<r;j++){
                if(m[i][j]!=m[u][l])
                leaf=false;
            }
            if(!leaf)
            break;
        }
        Node node=new Node(m[u][l]==1,leaf);
        if(!leaf){
            node.topLeft=build(m,l,(l+r)/2,u,(u+d)/2);
            node.topRight=build(m,(l+r)/2,r,u,(u+d)/2);
            node.bottomLeft=build(m,l,(l+r)/2,(u+d)/2,d);
            node.bottomRight=build(m,(l+r)/2,r,(u+d)/2,d);
        }
        return node;
    }
    public Node construct(int[][] grid) {
        int n=grid.length;
        return build(grid,0,n,0,n);
    }
}