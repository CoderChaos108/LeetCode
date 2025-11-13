class Solution {
    public int maxOperations(String s) {
        int ones=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
            continue;
            int j=i+1;
            ones++;
            while(j<s.length()&&s.charAt(j)=='0')
            j++;
            if(j!=i+1)
            ans=ans+ones;
            i=j-1;
        }
        return ans;
    }
}