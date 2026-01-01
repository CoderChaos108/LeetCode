class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans;
        ans=new int[digits.length+1];
        if(digits.length==1&&digits[0]==9){
            ans[0]=1;
            ans[1]=0;
            return ans;
        }
        for(int i=digits.length-1;i>=0;i--)
        {   
            if(i==0 && digits[0]==9){
                ans[0]=1;
                for(int j=1;j<ans.length;j++){
                    ans[j]=0;

                }
                break;
            }
            if(digits[i]!=9)
            {
                digits[i]=digits[i]+1;
                return digits;
            }
            else{
            digits[i]=0;
            }
        }
        return ans;
    }
}