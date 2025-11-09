class Solution {
    public int countOperations(int num1, int num2) {
        int ans=0;
        while(num1!=0&&num2!=0){
            if(num1==1){
                return ans+num2;
            }
            else if(num2==1)
            return ans+num1;
            if(num1>=num2){
                ans=ans+num1/num2;
                num1=num1%num2;
            
            }
            else{
                ans=ans+num2/num1;
            num2=num2%num1;
            }
        }
        return ans;
    }
}