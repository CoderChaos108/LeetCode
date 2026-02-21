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
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder builder=new StringBuilder(s);
        HashSet<String> set=new HashSet<>();
        Queue<StringBuilder> q=new LinkedList<>();
        q.add(builder);
        boolean found=false;
        HashSet<String> seen=new HashSet<>();
        while(!found){
            int size=q.size();
            while(size--!=0){
                StringBuilder sb=q.poll();
                if(!seen.add(sb.toString()))
                continue;
                if(check(sb.toString())){
                    found=true;
                    set.add(sb.toString());
                    continue;
                }
                for(int i=0;i<sb.length();i++){
                    char c=sb.charAt(i);
                    if(c!='('&&c!=')')
                    continue;
                    sb.deleteCharAt(i);
                    q.add(new StringBuilder(sb));
                    sb.insert(i,c);
                }
            }
        }
        return new ArrayList<>(set);
    }
}