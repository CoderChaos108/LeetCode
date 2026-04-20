class Solution {
    int[] dp;

    public int jump(int i,List<Integer>[] a){
        if(dp[i]!=-1)
        return dp[i];

        int ans=1;

        for(int j:a[i]){
            ans=Math.max(ans,1+jump(j,a));
        }

        dp[i]=ans;
        return ans;
    }

    public int maxJumps(int[] arr,int d) {

        int n=arr.length;

        List<Integer>[] a=new ArrayList[n];

        for(int i=0;i<n;i++)
        a[i]=new ArrayList<>();

        for(int i=0;i<n;i++){

            int l=1;

            while(l<=d && i-l>=0){

                if(arr[i-l]>=arr[i])
                break;

                a[i].add(i-l);
                l++;
            }

            int r=1;

            while(r<=d && i+r<n){

                if(arr[i+r]>=arr[i])
                break;

                a[i].add(i+r);
                r++;
            }
        }

        dp=new int[n];
        Arrays.fill(dp,-1);

        int res=1;

        for(int i=0;i<n;i++)
        res=Math.max(res,jump(i,a));

        return res;
    }
}