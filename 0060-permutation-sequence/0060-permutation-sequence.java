class Solution {
    public static String getPermutation(int n, int k) {
        int[] f=new int[n+1];
        int m=1;
        f[0]=1;
        for(int i=1;i<=n;i++){
        m=m*i;
        f[i]=m;
        }
        String s="";
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        for(int j=0;j<n;j++){
            sum=0;
            for(int i=1;i<=n;i++){
                if(set.contains(i))
                continue;
                sum=sum+f[n-1-s.length()];
                if(sum==k){
                    s=s+String.valueOf(i);
                    set.add(i);
                    for(int t=n;t>=1;t--){
                        if(!set.contains(t)){
                            s=s+String.valueOf(t);
                        }
                    }
                    return s;
                }
                if(sum>k){
                    s=s+String.valueOf(i);
                    set.add(i);
                    k=k-sum+f[n-s.length()];
                    break;
                }
            }
        }
        return s;
    }
}