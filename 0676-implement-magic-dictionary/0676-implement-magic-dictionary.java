class MagicDictionary {
    public class TrieNode{
        boolean isEnd;
        TrieNode[] children=new TrieNode[26];
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
        public boolean search(String s,TrieNode node,boolean changed){
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                TrieNode child=node.children[c-'a'];
                String newWord=s.substring(i+1,s.length());
                if(child!=null){
                    if(search(newWord,child,changed))
                    return true;
                }
                    if(changed)
                    return false;
                    for(int j=0;j<26;j++){
                        if(c-'a'==j)
                        continue;
                        if(node.children[j]!=null){
                            if(search(newWord,node.children[j],true))
                            return true;
                        }
                    }
                    return false;
                
            }
            return node.isEnd&&changed;
        }
    }
    Trie trie;
    public MagicDictionary() {
        trie=new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s:dictionary)
        trie.add(s);
    }
    
    public boolean search(String searchWord) {
        return trie.search(searchWord,trie.root,false);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */