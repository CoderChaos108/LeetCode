class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int i=num1;i<=num2;i++){
            if(i<100)
            continue;
            String s=String.valueOf(i);
            int l=s.length();
            for(int j=1;j<l-1;j++){
                int last=s.charAt(j-1)-'0';
                int curr=s.charAt(j)-'0';
                int next=s.charAt(j+1)-'0';
                if((last<curr&&next<curr)||(last>curr&&next>curr))
                    ans++;
            }
        }
        return ans;
    }
}