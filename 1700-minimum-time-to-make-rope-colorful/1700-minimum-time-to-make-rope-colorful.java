class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost=0;
        int n=colors.length();
        for(int i=0;i<n;i++){
            int j=i;
            char ch=colors.charAt(i);
            int c=0;
            int maxCost=-1;
            int total=0;
            while(j<n&&ch==colors.charAt(j)){
                c++;
                total=total+neededTime[j];
                maxCost=Math.max(maxCost,neededTime[j]);
                j++;
            }
            i=j-1;
            if(c!=1){
                cost=total-maxCost+cost;
            }
        }
        return cost;
    }
}