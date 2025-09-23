class Solution {
    List<String> ans=new ArrayList<>();
    String s;
    public void find(StringBuilder sb,int k,int curr,int points){
        if(points>3)
        return;
        if(k>=s.length()){
            if(points==3)
            ans.add(sb.toString());
            return;
        }
        int val=s.charAt(k)-'0';
        val=curr*10+val;
        if(val>255)
        return;
        if(val!=0||(val==0&&k==s.length()-1)){
            sb.append(s.charAt(k));
            find(sb,k+1,val,points);
            sb.setLength(sb.length()-1);
        }
        if(k!=s.length()-1){
            sb.append(s.charAt(k));
            sb.append('.');
            find(sb,k+1,0,points+1);
            sb.setLength(sb.length()-2);
        }
    }
    public List<String> restoreIpAddresses(String str) {
        if(str.length()>12)
        return ans;
        s=str;
        find(new StringBuilder(),0,0,0);
        return ans;
    }
}