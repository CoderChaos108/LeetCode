class Solution {
    int sq;
    public void push(int b,int[] nums2,int[] lazy,HashMap<Integer,Integer>[] a){
        if(lazy[b]==0)
        return;
        int l=b*sq;
        a[b]=new HashMap<>();
        HashMap<Integer,Integer> hm=a[b];
        
        int r=Math.min(nums2.length,(b+1)*sq);
        for(int i=l;i<r;i++){
            nums2[i]=nums2[i]+lazy[b];
            hm.put(nums2[i],hm.getOrDefault(nums2[i],0)+1);
        }
        lazy[b]=0;
    }
    public void rebuild(int b,int[] nums2,HashMap<Integer,Integer>[] a){
        a[b]=new HashMap<>();
        HashMap<Integer,Integer> hm=a[b];
        int l=b*sq;
        int r=Math.min(nums2.length,(b+1)*sq);
        for(int i=l;i<r;i++)
        hm.put(nums2[i],hm.getOrDefault(nums2[i],0)+1);
    }
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {
        int n=nums2.length;
        sq=(int)Math.sqrt(n);
        int size=(n+sq-1)/sq;
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer>[] a=new HashMap[size];
        for(int i=0;i<size;i++)
        a[i]=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            int b=i/sq;
            HashMap<Integer,Integer> hm=a[b];
            hm.put(nums2[i],hm.getOrDefault(nums2[i],0)+1);
        }
        int[] lazy=new int[size];
        for(int[] q:queries){
            if(q[0]==1){
                int x=q[1];
                int y=q[2];
                int v=q[3];
                int bl=x/sq;
                int br=y/sq;
                if(bl==br){
                    push(bl,nums2,lazy,a);
                    for(int i=x;i<=y;i++)
                    nums2[i]=nums2[i]+v;
                    rebuild(bl,nums2,a);
                }
                else{
                    push(bl,nums2,lazy,a);
                    for(int i=x;i<(bl+1)*sq;i++)
                    nums2[i]=nums2[i]+v;
                    rebuild(bl,nums2,a);
                    push(br,nums2,lazy,a);
                    for(int i=y;i>=br*sq;i--)
                    nums2[i]=nums2[i]+v;
                    rebuild(br,nums2,a);
                }
                int b=x/sq+1;
                while(b<y/sq){
                    lazy[b]=lazy[b]+v;
                    b++;
                }
            }
            else{
                int res=0;
                for(int i:nums1){
                    int tot=q[1];
                    for(int j=0;j<a.length;j++){
                        HashMap<Integer,Integer> hm=a[j];
                        int target=tot-i-lazy[j];
                        res=res+hm.getOrDefault(target,0);
                    }
                }
                list.add(res);
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++)
        ans[i]=list.get(i);
        return ans;
    }
}