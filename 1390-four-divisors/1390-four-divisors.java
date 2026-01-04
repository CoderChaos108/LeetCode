class Solution {
    public int sumFourDivisors(int[] nums) {
        int max=0;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i:nums)
        max=Math.max(i,max);
        for(int i=1;i<=max;i++){
            for(int j=1;i*j<=max;j++){
                if(!hm.containsKey(i*j)){
                hm.put(i*j,new ArrayList<>());
                }
                if(hm.get(i*j).size()>4)
                continue;
                hm.get(i*j).add(i);
            }
        }
        int ans=0;
        for(int key:nums){
            if(hm.get(key).size()==4){
                for(int i:hm.get(key))
                ans=ans+i;
            }
        }
        return ans;
    }
}