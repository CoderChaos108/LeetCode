class Solution {
    public double averageWaitingTime(int[][] customers) {
        double wait=0;
        int t=0;
        for(int[] a:customers){
            int arrival=a[0];
            int cookTime=a[1];
            int start=Math.max(t,arrival);
            int finish=start+cookTime;
            wait=wait+finish-arrival;
            t=finish;
        }
        return (wait*1.0)/(customers.length*1.0);
    }
}