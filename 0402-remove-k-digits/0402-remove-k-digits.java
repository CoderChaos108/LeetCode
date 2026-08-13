class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char c=num.charAt(i);
            while(!st.isEmpty()&&st.peek()>c&&k!=0){
                st.pop();
                k--;
            }
            if(c=='0'&&st.isEmpty())
            continue;
            st.push(c);
        }
        while(k!=0&&!st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        if(sb.length()==0)
        sb.append("0");
        return sb.toString();
    }
}