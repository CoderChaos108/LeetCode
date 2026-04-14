class Solution {
    public int find(int n,HashMap<Integer,Integer> hm){
        if(n==1)
        return 0;
        if(hm.containsKey(n))
        return hm.get(n);
        int x=0;
        if(n%2==0)
        x=n/2;
        else
        x=3*n+1;
        hm.put(n,find(x,hm)+1);
        return hm.get(n);
    }
    public int getKth(int lo, int hi, int k) {
        List<List<Integer>> list=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int n=lo;n<=hi;n++){
            list.add(Arrays.asList(find(n,hm),n));
        }
        Collections.sort(list,(a,b)->{
            if(a.get(0)!=b.get(0))
            return a.get(0)-b.get(0);
            else
            return a.get(1)-b.get(1);
        });
        return list.get(k-1).get(1);
    }
}