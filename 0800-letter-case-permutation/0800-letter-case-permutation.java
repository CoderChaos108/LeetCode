class Solution {
    List<String> ans=new ArrayList<>();
    int n;
    String s;
    public void find(StringBuilder sb,int k){
        if(k==n){
            ans.add(sb.toString());
            return;
        }
            char c=s.charAt(k);
            sb.append(Character.toLowerCase(c));
            find(sb,k+1);
            sb.setLength(sb.length()-1);
            if(Character.isDigit(c))
            return;
            sb.append(Character.toUpperCase(c));
            find(sb,k+1);
            sb.setLength(sb.length()-1);
    }
    public List<String> letterCasePermutation(String str){
        s=str;
        n=s.length();
        find(new StringBuilder(),0);
        return ans;
    }
}