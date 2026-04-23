class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i]))
            hm.put(nums[i],new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
        long[] a=new long[nums.length];
        HashMap<Integer,List<Long>> pm=new HashMap<>();
        for(int i:nums){
            if(pm.containsKey(i))
            continue;
            pm.put(i,new ArrayList<>());
            List<Integer> list=hm.get(i);
            List<Long> prefix=pm.get(i);
            long pre=0;
            for(int j:list){
                pre=pre+j;
                prefix.add(pre);
            }
        }
        for(int i=0;i<nums.length;i++){
            int idx=-1;
            List<Integer> list=hm.get(nums[i]);
            int l=0;
            int r=list.size()-1;
            while(l<=r){
                int m=(l+r)/2;
                if(list.get(m)>i){
                    r=m-1;
                }
                else if(list.get(m)<i)
                l=m+1;
                else{
                    idx=m;
                    break;
                }
            }
            int f=list.size();
            List<Long> prefix=pm.get(nums[i]);
            if(list.size()==1)
            continue;
            else if(idx==0){
                long right=prefix.get(list.size()-1)-i;
                right=right-(long)i*(list.size()-1);
                a[i]=right;
            }
            else if(idx==list.size()-1){
                long left=prefix.get(idx-1);
                left=(long)i*(list.size()-1)-left;
                a[i]=left;
            }
            else{
                long left,right;
                left=prefix.get(idx-1);
                left=(long)idx*i-left;
                right=prefix.get(list.size()-1);
                right=right-prefix.get(idx);
                right=right- (long)(list.size()-1-idx)*i;
                a[i]=left+right;
            }
        }
        return a;
    }
}