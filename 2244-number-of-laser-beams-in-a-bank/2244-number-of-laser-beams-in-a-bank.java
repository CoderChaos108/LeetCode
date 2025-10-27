class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int last=-1;
        for(String s:bank){
            int curr=0;
            for(int i=0;i<s.length();i++)
            curr=curr+(s.charAt(i)-'0');
            if(last==-1){
                if(curr!=0)
                last=curr;
            }
            else{
                if(curr!=0){
                    ans=ans+curr*last;
                    last=curr;
                }
            }
        }
        return ans;
    }
}