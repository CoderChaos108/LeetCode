class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=capital[i];
            a[i][1]=profits[i];
        }
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->y[1]-x[1]);
        int cap=w;
        int i=0;
        do{
            while(i<n&&a[i][0]<=cap){
            pq.add(a[i]);
            i++;
            }
            if(pq.isEmpty())
            break;
            int[] arr=pq.poll();
            cap=cap+arr[1];
            k--;
          
        }
        while(k!=0);
        return cap;
    }
}