class Solution {
    HashMap<Integer,HashSet> hm=new HashMap<>();
    public void merge(int i,int j){
        HashSet<Integer> set1=hm.get(i);
        HashSet<Integer> set2=hm.get(j);
        for(int n:set2)
        set1.add(n);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        for(int i:nums){
        hm.put(i,new HashSet<>());
        hm.get(i).add(i);
        }
        int ans=nums[0];
        for(int i=nums.length-1;i>=0;i--){
            int max=-1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]%nums[i]==0){
                    if(max==-1)
                    max=nums[j];
                    else{
                        if(hm.get(max).size()<hm.get(nums[j]).size())
                        max=nums[j];
                    }
                }
            }
            if(max!=-1){
            merge(nums[i],max);
                if(hm.get(ans).size()<hm.get(nums[i]).size())
                ans=nums[i];
            }
        }
        List<Integer> list=new ArrayList<>(hm.get(ans));
        return list;
    }
}