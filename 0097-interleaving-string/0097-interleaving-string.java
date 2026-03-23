class Solution {
    int[][][] dp;
    String s1,s2,s3;
    int l1,l2,l3;
    public boolean find(int p,int q,int r){
        if(r>=l3)
        return true;
        if(dp[p][q][r]!=0){
            return dp[p][q][r]==1;
        }
        if(p>=l1&&q>=l2){
            dp[p][q][r]=-1;
            return false;
        }
        if(p>=l1){
            if(s2.charAt(q)==s3.charAt(r)){
                boolean res=find(p,q+1,r+1);
                if(res)
                dp[p][q][r]=1;
                else
                dp[p][q][r]=-1;
                return res;
            }
            else{
                dp[p][q][r]=-1;
                return false;
            }
        }
        if(q>=l2){
            if(s1.charAt(p)==s3.charAt(r)){
                boolean res=find(p+1,q,r+1);
                if(res)
                dp[p][q][r]=1;
                else
                dp[p][q][r]=-1;
                return res;
            }
            else{
                dp[p][q][r]=-1;
                return false;
            }
        }
        char a=s1.charAt(p);
        char b=s2.charAt(q);
        char c=s3.charAt(r);
        if(a==c&&b==c){
            boolean res=find(p+1,q,r+1)||find(p,q+1,r+1);
            if(res)
            dp[p][q][r]=1;
            else
            dp[p][q][r]=-1;
            return res;
        }
        if(a==c){
            boolean res=find(p+1,q,r+1);
            if(res)
            dp[p][q][r]=1;
            else
            dp[p][q][r]=-1;
            return res;
        }
        else if(b==c){
            boolean res=find(p,q+1,r+1);
            if(res)
            dp[p][q][r]=1;
            else
            dp[p][q][r]=-1;
            return res;
        }
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int p=0;
        int q=0;
        int r=0;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        l1=s1.length();
        l2=s2.length();
        l3=s3.length();
        if(s1.length()+s2.length()!=s3.length())
        return false;
        dp=new int[s1.length()+1][s2.length()+1][s3.length()+1];
        return find(0,0,0);
    }
}