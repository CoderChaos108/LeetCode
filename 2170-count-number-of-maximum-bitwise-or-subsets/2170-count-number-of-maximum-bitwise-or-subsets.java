class Solution {
    int[] a;
    int ans=0;
    public void find(int val,int k,int t){
        if(k==a.length){
            if(t!=0){
            hm.put(val,hm.getOrDefault(val,0)+1);
            ans=Math.max(ans,hm.get(val));
            }
            return;
        }
        find(val,k+1,t);
        find(val|a[k],k+1,t+1);
    }
    HashMap<Integer,Integer> hm=new HashMap<>();
    public int countMaxOrSubsets(int[] nums) {
        a=nums;
        find(0,0,0);
        return ans;
    }
}