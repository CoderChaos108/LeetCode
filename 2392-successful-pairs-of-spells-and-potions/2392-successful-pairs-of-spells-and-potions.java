class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int l=0;
            int r=potions.length-1;
            while(l<=r){
                int m=(l+r)/2;
                long val=(long)spells[i]*(long)potions[m];
                if(val<success){
                    l=m+1;
                }
                else
                r=m-1;
            }
            ans[i]=potions.length-l;
        }
        return ans;
    }
}