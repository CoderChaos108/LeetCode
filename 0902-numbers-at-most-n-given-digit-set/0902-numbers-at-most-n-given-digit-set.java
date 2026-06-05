class Solution {
    int[][][] dp;
    int[] a;
    public int find(int i,int started,int tight,String s){
        if(i==s.length()){
            if(started==0)
            return 0;
            return 1;
        }
        if(dp[i][started][tight]!=-1)
        return dp[i][started][tight];
        int res=0;
        if(started==0)
        res=res+find(i+1,0,0,s);
        int lim=9;
        if(tight==1)
        lim=s.charAt(i)-'0';
        for(int d:a){
            if(d>lim)
            break;
            int newTight=0;
            if(tight==1&&d==lim)
            newTight=1;
            res=res+find(i+1,1,newTight,s);
        }
        dp[i][started][tight]=res;
        return res;
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        dp=new int[11][2][2];
        a=new int[digits.length];
        for(int i=0;i<a.length;i++)
        a[i]=Integer.valueOf(digits[i]);
        for(int i=0;i<11;i++)
        for(int j=0;j<2;j++)
        for(int k=0;k<2;k++)
        dp[i][j][k]=-1;
        return find(0,0,1,String.valueOf(n));
    }
}