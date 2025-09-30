class Solution {
    HashSet<String> set=new HashSet<>();
    String s;
    int ans=0;
    public void find(StringBuilder sb,int k,int parts){
        if(k>=s.length()){
            ans=Math.max(parts,ans);
            return;
        }    
        sb.append(s.charAt(k));
        find(sb,k+1,parts);
        String curr=sb.toString();
        if(curr.length()!=0&&set.add(curr)){
        find(new StringBuilder(),k+1,parts+1);
         set.remove(curr);
        }
        sb.setLength(sb.length()-1);
    }
    public int maxUniqueSplit(String s) {
        this.s=s;
        find(new StringBuilder(),0,0);
        return ans;
    }
}