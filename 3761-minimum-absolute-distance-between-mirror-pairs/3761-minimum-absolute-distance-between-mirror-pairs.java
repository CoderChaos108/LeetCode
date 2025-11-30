class Solution {
    public int rev(int n){
        int r=0;
        int d=n;
        while(d!=0){
            r=r*10+d%10;
            d=d/10;
        }
        return r;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i]))
            hm.put(nums[i],new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int reverse=rev(nums[i]);
            if(hm.containsKey(reverse)){
                List<Integer> li=hm.get(reverse);
                int l=0;
                int r=li.size()-1;
                int pos=-1;
                while(l<=r){
                    int m=(l+r)/2;
                    if(li.get(m)>i){
                        pos=m;
                        r=m-1;
                    }
                    else{
                        l=m+1;
                    }
                }
                if(pos!=-1)
                ans=Math.min(ans,li.get(pos)-i);
            }
        }
        if(ans==Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}
