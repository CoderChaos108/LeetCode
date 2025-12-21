class Solution {
    public long minCost(String s, int[] cost) {
        long sum=0;
        for(int c:cost)
        sum=sum+c;
        long[] a=new long[26];
        for(int i=0;i<cost.length;i++){
            a[s.charAt(i)-'a']=a[s.charAt(i)-'a']+cost[i];
        }
        long max=0;
        for(long i:a)
        max=Math.max(max,i);
        return sum-max;
    }
}