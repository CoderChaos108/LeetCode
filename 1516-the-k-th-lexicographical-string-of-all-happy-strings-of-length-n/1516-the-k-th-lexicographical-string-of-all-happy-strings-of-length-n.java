class Solution {
    int c=0;
    String ans="";
    int k;
    int n;
    public void find(StringBuilder sb){
        if(sb.length()==n){
            c++;
            if(c==k)
            ans=sb.toString();
            return;
        }
        if(c>=k)
        return;
        if(sb.length()==0||sb.charAt(sb.length()-1)!='a'){
        sb.append('a');
        find(sb);
        sb.setLength(sb.length()-1);
        }
        if(sb.length()==0||sb.charAt(sb.length()-1)!='b'){
        sb.append('b');
        find(sb);
        sb.setLength(sb.length()-1);
        }
        if(sb.length()==0||sb.charAt(sb.length()-1)!='c'){
        sb.append('c');
        find(sb);
        sb.setLength(sb.length()-1);
        }
    }
    public String getHappyString(int n, int k) {
        this.k=k;
        this.n=n;
        find(new StringBuilder());
        return ans;
    }
}