class Solution {
    List<String> ans=new ArrayList<>();
    int n;
    String s;
    public void find(StringBuilder sb,int k){
        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }
        for(int i=k;i<n;i++){
            char c=s.charAt(i);
            sb.append(c);
            find(sb,i+1);
            sb.setLength(sb.length()-1);
            if(Character.isDigit(c))
            continue;
            if(Character.isLowerCase(c))
            c=Character.toUpperCase(c);
            else
            c=Character.toLowerCase(c);
            sb.append(c);
            find(sb,i+1);
            sb.setLength(sb.length()-1);
        }
    }
    public List<String> letterCasePermutation(String str){
        s=str;
        n=s.length();
        find(new StringBuilder(),0);
        return ans;
    }
}