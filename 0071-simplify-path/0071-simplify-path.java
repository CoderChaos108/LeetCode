class Solution {
    public String simplifyPath(String path) {
        int l=0;
        int r=1;
        StringBuilder sb=new StringBuilder();
        Stack st=new Stack(); 
        while(r<path.length()){
            while(r<path.length()&&path.charAt(r)!='/'){
                r++;
            }
            if(r==l+1){
            l=r;
            r++;
            continue;
            }
            String s=path.substring(l,r);
            l=r;
            r++;
            if(s.equals("/.")||s.equals("/"))
            continue;
            if(s.equals("/..")){
                if(!st.isEmpty())
                st.pop();
                continue;
            }
            st.push(s);
        }
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        if(sb.length()==0)
        sb.append("/");
        return sb.toString();
    }
}