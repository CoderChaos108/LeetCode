class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)
        return false;
        int x=0;
        int y=0;
        int z=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
            st.push('(');
            x++;
            }
            else if(s.charAt(i)=='['){
            st.push('[');
            y++;
            }
            else if(s.charAt(i)=='{'){
            st.push('{');
            z++;
            }
            else if(s.charAt(i)==')'){
                x--;
                if(st.empty()||st.peek()!='(')
                return false;
                st.pop();
            }
            else if(s.charAt(i)==']'){
                y--;
                if(st.empty()||st.peek()!='[')
                return false;
                st.pop();
            }
            else{
                z--;
                if(st.empty()||st.peek()!='{')
                return false;
                st.pop();
            }
        }
        if(x!=0||y!=0||z!=0)
        return false;
        return true;
    }
}