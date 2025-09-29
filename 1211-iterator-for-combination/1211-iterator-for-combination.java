class CombinationIterator {
    List<String> ans=new ArrayList<>();
    int l;
    String s;
    public void find(StringBuilder sb,int k){
        if(sb.length()==l){
            ans.add(sb.toString());
            return;
        }
        if(k>=s.length())
        return;
        sb.append(s.charAt(k));
        find(sb,k+1);
        sb.setLength(sb.length()-1);
        find(sb,k+1);
    }
    int itr=0;
    public CombinationIterator(String characters, int combinationLength) {
    l=combinationLength;
    s=characters;
    find(new StringBuilder(),0);
    }
    
    public String next() {
        return ans.get(itr++);
    }
    
    public boolean hasNext() {
        if(itr<ans.size())
        return true;
        return false;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */