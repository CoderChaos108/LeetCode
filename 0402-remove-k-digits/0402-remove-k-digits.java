class Solution {
    public String removeKdigits(String num,int k) {
        int n=num.length();
        StringBuilder st=new StringBuilder();

        for(int i=0;i<n;i++){
            char c=num.charAt(i);

            while(st.length()>0&&st.charAt(st.length()-1)>c&&k!=0){
                st.setLength(st.length()-1);
                k--;
            }

            if(c=='0'&&st.length()==0)
                continue;

            st.append(c);
        }

        while(k!=0&&st.length()>0){
            st.setLength(st.length()-1);
            k--;
        }

        if(st.length()==0)
            return "0";

        return st.toString();
    }
}