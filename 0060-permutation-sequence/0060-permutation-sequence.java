class Solution {
    public static String getPermutation(int n, int k) {
        int[] f=new int[n+1];
        StringBuilder s=new StringBuilder();
        int m=1;
        f[0]=1;
        for(int i=1;i<=n;i++){
        m=m*i;
        f[i]=m;
        }
        int sum=0;
        int[] used=new int[n+1];
        for(int j=0;j<n;j++){
            sum=0;
            for(int i=1;i<=n;i++){
                if(used[i]==1)
                continue;
                sum=sum+f[n-1-s.length()];
                if(sum==k){
                    s.append(String.valueOf(i));
                    used[i]=1;
                    for(int t=n;t>=1;t--){
                        if(used[t]==0){
                            s.append(String.valueOf(t));
                        }
                    }
                    return s.toString();
                }
                if(sum>k){
                    s.append(String.valueOf(i));
                    used[i]=1;
                    k=k-sum+f[n-s.length()];
                    break;
                }
            }
        }
        return s.toString();
    }
}
