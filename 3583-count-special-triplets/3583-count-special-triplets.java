class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        long c=0,mod=1000000007;
        for(int i=0;i<nums.length;i++){
            int val=2*nums[i];
            if(hm.containsKey(val)){
                ArrayList<Integer> l=hm.get(val);
                int p=0,low=0,high=l.size()-1;
                while(low<=high){
                    int mid=(low+high)/2;
                    if(l.get(mid)<i){
                        p=mid+1;
                        low=mid+1;
                    }else{
                        high=mid-1;
                    }
                }
                int q=0;
                low=0;
                high=l.size()-1;
                while(low<=high){
                    int mid=(low+high)/2;
                    if(l.get(mid)>i){
                        q=l.size()-mid;
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                c=(c+(long)p*q)%mod;
            }
        }
        return (int)c;
    }
}
