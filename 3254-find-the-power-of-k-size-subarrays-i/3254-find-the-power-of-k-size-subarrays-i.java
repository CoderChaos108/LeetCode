class Solution {
        public int sorted(List<Integer> list){
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)!=list.get(i+1)-1)
                return -1;
            }
            return list.get(list.size()-1);
        }
        public int[] resultsArray(int[] nums, int k) {
        List<Integer> list=new LinkedList<>();
        int itr=0;
        int[] a=new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            list.add(nums[i]);
        }
        a[itr++]=sorted(list);
        for(int i=k;i<nums.length;i++){
            list.removeFirst();
            list.add(nums[i]);
            a[itr++]=sorted(list);
        }
        return a;
    }
}