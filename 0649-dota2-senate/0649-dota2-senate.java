class Solution {
    public String predictPartyVictory(String s) {
        StringBuilder sb=new StringBuilder();
        int l=s.length();
        int rs=0;
        int ds=0;
        int r=0;
        int d=0;
        for(int i=0;i<l;i++){
            if(s.charAt(i)=='R'){
                if(rs>0){
                    rs--;
                    continue;
                }
                sb.append('R');
                r++;
                ds++;
            }
            else{
                if(ds>0){
                    ds--;
                    continue;
                }
                sb.append('D');
                rs++;
                d++;
            }
        }
        while(d!=0&&r!=0){
            s=sb.toString();
            sb.setLength(0);
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='R'){
                if(rs>0){
                    rs--;
                    r--;
                    if(r==0)
                    return "Dire";
                    continue;
                }
                sb.append('R');
                ds++;
            }
            else{
                if(ds>0){
                    ds--;
                    d--;
                    if(d==0)
                    return "Radiant";
                    continue;
                }
                sb.append('D');
                rs++;
            }
            }
        }
        if(r==0)
        return "Dire";
        else
        return "Radiant";
    }
}