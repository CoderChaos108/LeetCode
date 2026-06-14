class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int r=arr.length-1;
        int p=-1;
        int q=arr.length;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]<=x){
                l=m+1;
                p=m;
            }
            else
            r=m-1;
        }
        l=0;
        r=arr.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]>x){
                q=m;
                r=m-1;
            }
            else
            l=m+1;
        }
        int idx=0;
        int[] a=new int[k];
        while(idx!=k){
            if(p<0){
                a[idx++]=arr[q++];
            }
            else if(q>=arr.length){
                a[idx++]=arr[p--];
            }
            else{
                int le=arr[p];
                int re=arr[q];
                if(Math.abs(le-x)<Math.abs(re-x)){
                    a[idx++]=arr[p--];
                }
                else if(Math.abs(le-x)>Math.abs(re-x))
                a[idx++]=arr[q++];
                else{
                    if(le<re)
                    a[idx++]=arr[p--];
                    else
                    a[idx++]=arr[q++];
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=p+1;i<q;i++)
        list.add(arr[i]);
        return list;
    }
}