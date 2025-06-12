class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int c=0;
        for(int i=0;i<ages.length;i++){
            if(ages[i]>14){
                int k=i+1;
                while(k<ages.length&&ages[i]==ages[k]){
                c++;
                k++;
                }
            }
            int p=i-1;
            double limit=ages[i]*0.5+7;
            while(p>=0&&(double)ages[p]>limit){
                c++;
                p--;
            }
        }
        return c;
    }
}