class Solution {
    public boolean check(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!='('&&c!=')')
            continue;
            if(c=='(')
            st.push(c);
            else{
                if(st.isEmpty())
                return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
    HashSet<String> seen=new HashSet<>();
    int found=-1;
    List<String> list=new ArrayList<>();
    public void backtrack(StringBuilder sb){
        if(!seen.add(sb.toString()))
        return;
        if(check(sb.toString())){
            list.add(sb.toString());
            found=Math.max(found,sb.length());
            return;
        }
        if(sb.length()<found)
        return;
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(c!='('&&c!=')')
            continue;
            sb.deleteCharAt(i);
            backtrack(sb);
            sb.insert(i,c);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb=new StringBuilder(s);
        backtrack(sb);
        int max=0;
        for(String str:list)
        max=Math.max(str.length(),max);
        List<String> ans=new ArrayList<>();
        for(String str:list){
            if(str.length()==max)
            ans.add(str);
        }
        return ans;
    }
}