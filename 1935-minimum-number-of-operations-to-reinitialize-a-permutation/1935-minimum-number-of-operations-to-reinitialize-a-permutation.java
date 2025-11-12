class Solution {
    public int reinitializePermutation(int n) {
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        a[i]=i;
        boolean same=false;
        int ans=0;
        while(true){
            same=true;
            int[] an=new int[n];
            for(int i=0;i<n;i++){
                if(a[i]!=i)
                same=false;
                an[i]=a[i];
            }
            if(same&&ans!=0)
            return ans;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    an[i]=a[i/2];
                }
                else
                an[i]=a[n/2+(i-1)/2];
            }
            a=an;
             ans++;
        }
    }
}