class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost=0;
        for(int i=0;i<colors.length();i++){
            int j=i;
            int c=0;
            int maxCost=-1;
            int total=0;
            while(j<colors.length()&&colors.charAt(j)==colors.charAt(i)){
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