class Solution {
    public int magicalString(int n) {
        String s="122";
        int d=1;
        int i=3;
        int c=1;
        int t=i;
        while(i<n){
            for(int j=1;j<=s.charAt(i-1)-'0';j++){
                if(t+1<=n&&d==1){
                s=s+'1';
                c++;
                t++;
                }
                if(t+1<=n&&d==2){
                s=s+'2';
                t++;
                }
                if(t+1>n)
                return c;
            }
            if(d==1)
            d=2;
            else
            d=1;
            i++;

        }
        return c;
    }
}