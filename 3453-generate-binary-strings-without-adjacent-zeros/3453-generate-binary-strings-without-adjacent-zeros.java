class Solution {
    List<String> ans=new ArrayList<>();
    int n;
    public void find(StringBuilder sb,boolean valid){
        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }
        sb.append('1');
        find(sb,true);
        sb.setLength(sb.length()-1);
        if(valid){
            sb.append('0');
            find(sb,false);
            sb.setLength(sb.length()-1);
        }
    }
    public List<String> validStrings(int n) {
        this.n=n;
        find(new StringBuilder(),true);
        return ans;
    }
}