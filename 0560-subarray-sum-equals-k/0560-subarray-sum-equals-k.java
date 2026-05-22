class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix=new int[nums.length+1];
        int s=0;
        for(int i=0;i<nums.length;i++){
            prefix[i]=s;
            s=s+nums[i];
        }
        prefix[nums.length]=s;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<prefix.length;i++){
            int p=prefix[i];
            if(!hm.containsKey(prefix[i]))
            hm.put(prefix[i],new ArrayList<>());
            List<Integer> list=hm.get(p);
            list.add(i);
        }
        int ans=0;
        for(int i=0;i<prefix.length;i++){
            int p=prefix[i];
            int o=p+k;
            if(!hm.containsKey(o))
            continue;
            List<Integer> list=hm.get(o);
            for(int j=0;j<list.size();j++){
                if(list.get(j)>i){
                    ans=ans+(list.size()-j);
                    break;
                }
            }
        }
        return ans;
    }
}