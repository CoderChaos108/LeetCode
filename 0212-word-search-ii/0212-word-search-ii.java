class Solution {
    public class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }
    public class Trie{
        TrieNode root;
        public Trie(){
            root=new TrieNode();
        }
        public void add(String s){
            TrieNode node=root;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode();
                node=node.children[c-'a'];
            }
            node.isEnd=true;
        }
        public TrieNode starts(char c){
            return root.children[c-'a'];
        }
    }
    int m,n;
    char[][] a;
    boolean[][] seen;
    List<String> ans=new ArrayList<>();
    public void dfs(int i,int j,TrieNode node,StringBuilder sb){
        if(i<0||j<0||i>=m||j>=n||seen[i][j])
        return;
        char c=a[i][j];
        TrieNode newNode=node.children[c-'a'];
        if(newNode==null)
        return;
        seen[i][j]=true;
        sb.append(c);
        if(newNode.isEnd){
        newNode.isEnd=false;
        ans.add(sb.toString());
        }
        dfs(i+1,j,newNode,sb);
        dfs(i-1,j,newNode,sb);
        dfs(i,j+1,newNode,sb);
        dfs(i,j-1,newNode,sb);
        sb.setLength(sb.length()-1);
        seen[i][j]=false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        a=board;
        m=a.length;
        n=a[0].length;
        seen=new boolean[m][n];
        Trie trie=new Trie();
        for(String s:words)
        trie.add(s);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(i,j,trie.root,new StringBuilder());
            }
        }
        return ans;
    }
}