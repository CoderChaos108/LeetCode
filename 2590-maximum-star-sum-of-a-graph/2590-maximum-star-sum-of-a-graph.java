class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n=vals.length;
        PriorityQueue<Integer>[] arr=new PriorityQueue[n];
        for(int i=0;i<n;i++){
            arr[i]=new PriorityQueue<>((a,b)->vals[b]-vals[a]);
        }
        for(int[] a:edges){
            int x=a[0];
            int y=a[1];
            arr[x].add(y);
            arr[y].add(x);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=vals[i];
            PriorityQueue<Integer> pq=arr[i];
            for(int j=0;j<k;j++){
                if(pq.isEmpty())
                break;
                int extracted=pq.poll();
                if(vals[extracted]<=0)
                break;
                sum=sum+vals[extracted];
            }
            ans=Math.max(sum,ans);
        }
        return ans;
    }
}