class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i=0;i<nums.length-3;i++){
            hm.put(nums[i],hm.get(nums[i])-1);
            if(hm.get(nums[i])==0)
            hm.remove(nums[i]);
            for(int j=i+1;j<nums.length-2;j++){
                hm.put(nums[j],hm.get(nums[j])-1);
                if(hm.get(nums[j])==0)
                hm.remove(nums[j]);
                for(int k=j+1;k<nums.length-1;k++){
                    hm.put(nums[k],hm.get(nums[k])-1);
                    if(hm.get(nums[k])==0)
                    hm.remove(nums[k]);
                    long rem=(long)target-(long)nums[i]-(long)nums[j]-(long)nums[k];
                    if(rem>=Integer.MIN_VALUE&&rem<=Integer.MAX_VALUE&&hm.containsKey((int)rem)){
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add((int)rem);
                        Collections.sort(list);
                        set.add(list);
                    }
                    hm.put(nums[k],hm.getOrDefault(nums[k],0)+1);
                }
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            }
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        return new ArrayList<>(set);
    }
}
