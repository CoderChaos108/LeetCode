class Trie{
    class TrieNode{
        TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        isEnd=false;
        children=new TrieNode[10];
    }
    }
    TrieNode root;
    public Trie(){
        root=new TrieNode();
    }
    public void add(String s){
        TrieNode node=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'0';
            if(node.children[idx]==null)
            node.children[idx]=new TrieNode();
            node=node.children[idx];
        }
    }
    public int search(String s){
        int c=0;
        TrieNode node=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'0';
            if(node.children[idx]==null)
            return c;
            c++;
            node=node.children[idx];
        }
        return c;
    }
}
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans=0;
        Trie trie=new Trie();
        for(int i:arr1){
            String s=String.valueOf(i);
            trie.add(s);
        }   
        for(int i:arr2){
            String s=String.valueOf(i);
            ans=Math.max(ans,trie.search(s));
        }
        return ans;
    }
}