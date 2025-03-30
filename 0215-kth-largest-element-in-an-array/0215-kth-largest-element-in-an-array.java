class Solution {
    public int findKthLargest(int[] a, int k) {
        int l=0;
        int s=0;
        for(int i=0;i<a.length;i++){
            if(l<a[i])
            l=a[i];
            if(s>a[i])
            s=a[i];
        }
        int[] f=new int[l+1];
        int[] nf=new int[-s+1];
        for(int i=0;i<a.length;i++){
            if(a[i]>=0)
            f[a[i]]++;
            else
            nf[-a[i]]++;
        }
        int index=0;
        for(int i=nf.length-1;i>0;i--){
            while(nf[i]!=0){
                a[index]=-i;
                index++;
                nf[i]--;
            }
        }
        for(int i=0;i<f.length;i++){
            while(f[i]!=0){
                a[index]=i;
                index++;
                f[i]--;
            }
        }
        return a[a.length-k];
    }
}