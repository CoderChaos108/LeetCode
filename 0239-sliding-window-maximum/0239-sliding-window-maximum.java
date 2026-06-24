class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->nums[b]-nums[a]);
        int[] a=new int[n-k+1];

        int l=0;
        int idx=0;
        for(int r=0;r<n;r++){
            pq.add(r);
            if(r-l+1<k){
                continue;
            }
            while(pq.peek()<l)
            pq.poll();
            a[idx++]=nums[pq.peek()];
            l++;
        }
        return a;
    }
}