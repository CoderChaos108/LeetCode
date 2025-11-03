class Solution {
    String s;
    String ans="";
    boolean[] seen=new boolean[10];
    public void find(StringBuilder sb,int k,int last){
        if(ans.length()!=0)
        return;
        if(k==s.length()){
            ans=sb.toString();
            return;
        }
        if(k==-1){
            for(int i=1;i<10;i++){
                seen[i]=true;
                sb.append((char)(i+'0'));
                find(sb,0,i);
                seen[i]=false;
                sb.setLength(0);
            }
        }
        else{
            if(s.charAt(k)=='I'){
                for(int i=last+1;i<10;i++){
                    if(seen[i])
                    continue;
                    seen[i]=true;
                    sb.append((char)(i+'0'));
                    find(sb,k+1,i);
                    seen[i]=false;
                    sb.setLength(sb.length()-1);
                }
            }
            else{
                for(int i=1;i<last;i++){
                    if(seen[i])
                    continue;
                    seen[i]=true;
                    sb.append((char)(i+'0'));
                    find(sb,k+1,i);
                    seen[i]=false;
                    sb.setLength(sb.length()-1);
                }
            }
        }
    }
    public String smallestNumber(String pattern) {
        s=pattern;
        find(new StringBuilder(),-1,-1);
        return ans;
    }
}