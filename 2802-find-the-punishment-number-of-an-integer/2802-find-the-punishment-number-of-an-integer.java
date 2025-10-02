class Solution {
    public boolean check(String s,int k,int val,int sum){
        if(k==s.length()){
            return sum+val==Math.sqrt(Integer.valueOf(s));
        }
        int d=s.charAt(k)-'0';
        if(val==0&&d==0){
            return check(s,k+1,0,sum);
        }
        else{
            return check(s,k+1,d,sum+val)||check(s,k+1,val*10+d,sum);
        }
    }
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            if(check(String.valueOf(i*i),0,0,0))
            ans=ans+i*i;
        }
        return ans;
    }
}