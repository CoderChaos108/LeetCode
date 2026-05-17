class Solution {
    int[] dp;
    int n;
    public boolean find(int i,int[] a){
        int val=a[i];
        if(val==0){
            dp[i]=1;
            return true;
        }
        if(dp[i]==1)
        return true;
        if(dp[i]==-1)
        return false;
        dp[i]=-1;
        int l=i-val;
        int r=i+val;
        if(l>=0&&l<n){
            boolean res=find(l,a);
            if(res){
            dp[i]=1;
            return true;
            }
            else
            dp[i]=-1;
        }
        if(r>=0&&r<n){
            boolean res=find(r,a);
            if(res){
            dp[i]=1;
            return true;
            }
            else
            dp[i]=-1;
        }
        return dp[i]==1;
    }
    public boolean canReach(int[] arr, int start) {
        n=arr.length;
        dp=new int[n];
        return find(start,arr);
    }
}