class Solution {
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
        hm.put(i,hm.getOrDefault(i,0)+1);
        HashSet<Integer> set=new HashSet<>();
        int ans=hm.getOrDefault(1,0);
        if(ans%2==0)
        ans=Math.max(ans-1,0);
        for(int i:nums){
            if(i==1)
            continue;
            int j=i;
            int c=0;
            while(hm.containsKey(j)&&hm.get(j)>=2&&hm.containsKey(j*j)){
                if(set.contains(j))
                break;
                set.add(j);
                c=c+2;
                j=j*j;
            }

            ans=Math.max(ans,c+1);
        }
        return ans;
    }
}