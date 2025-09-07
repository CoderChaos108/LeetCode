class Solution {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        int bound=n/2;
        if(n%2!=0){
            int temp=-bound;
            for(int i=0;i<n;i++){
                ans[i]=temp;
                temp++;
            }
        }
        else{
            int temp=-bound;
            for(int i=0;i<n/2;i++){
                ans[i]=temp;
                temp++;
            }
            temp=1;
            for(int i=n/2;i<n;i++){
                ans[i]=temp;
                temp++;
            }
        }
        return ans;
    }
}