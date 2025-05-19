class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        int[] a=new int[k];
        int l=0;
        int s=0;
        for(int i:nums){
            if(i<s)
            s=i;
            if(i>l)
            l=i;
        }

        int[] f=new int[l+1];
        int[] nf=new int[Math.abs(s)+1];
        for(int i:nums){
            if(i>=0)
            f[i]++;
            else
            nf[-i]++;
        }
        s=Math.abs(s)+1;
        l=l+1;
        int t=0;
    for(int i=1;i<s;i++){
        if(!hm.containsKey(nf[i])){
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(-i);
        hm.put(nf[i],list);
        }
        else{
            ArrayList<Integer> list=new ArrayList<Integer>(hm.get(nf[i]));
            list.add(-i);
            hm.put(nf[i],list);
        }
    }       
    for(int i=0;i<l;i++){
        if(!hm.containsKey(f[i])){
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(i);
        hm.put(f[i],list);
        }
        else{
            ArrayList<Integer> list=new ArrayList<Integer>(hm.get(f[i]));
            list.add(i);
            hm.put(f[i],list);
        }
    }
            int x=0;
            List<Integer> keys = new ArrayList<>(hm.keySet());
            Collections.sort(keys, Collections.reverseOrder());
            for(int key:keys){
                for(int i:hm.get(key)){
                    a[x]=i;
                    x++;
                    if(x==k)
                    return a;
                }
            }
            return a;
    }
}