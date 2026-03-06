class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<ArrayList<Integer>> pq =
            new PriorityQueue<>((a,b)->(b.get(0)+b.get(1))-(a.get(0)+a.get(1)));

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int s=nums1[i]+nums2[j];
                if(pq.size()==k){
                    ArrayList<Integer> pair=pq.poll();
                    int biggestSum=pair.get(0)+pair.get(1);
                    if(s<biggestSum){
                        pq.add(new ArrayList<>(Arrays.asList(nums1[i],nums2[j])));
                    }
                    else{
                        pq.add(pair);
                        break;
                    }
                }
                else{
                    pq.add(new ArrayList<>(Arrays.asList(nums1[i],nums2[j])));
                }
            }
        }

        List<List<Integer>> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}