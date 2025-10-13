class Solution {
    public class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd=false;
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
        public String rootify(String s){
            TrieNode node=root;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                TrieNode child=node.children[c-'a'];
                if(child==null)
                return s;
                sb.append(c);
                node=child;
                if(node.isEnd)
                return sb.toString();
            }
            if(node.isEnd)
            return sb.toString();
            return s;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie=new Trie();
        for(String s:dictionary)
        trie.add(s);
        String[] a=sentence.split("\\s");
        StringBuilder sb=new StringBuilder();
        for(String s:a){
            sb.append(trie.rootify(s));
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}