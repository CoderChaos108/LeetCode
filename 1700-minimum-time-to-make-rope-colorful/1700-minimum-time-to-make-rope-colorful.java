class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost=0;
        for(int i=0;i<colors.length();i++){
            int j=i;
            int maxCost=-1;
            int total=0;
            if(i==colors.length()-1||colors.charAt(i)!=colors.charAt(i+1));
            while(j<colors.length()&&colors.charAt(j)==colors.charAt(i)){
                total=total+neededTime[j];
                maxCost=Math.max(maxCost,neededTime[j]);
                j++;
            }
            i=j-1;
                cost=total-maxCost+cost;
        }
        return cost;
    }
}