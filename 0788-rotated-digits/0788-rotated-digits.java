class Solution {
    public int rotate(int d){
        if(d==0||d==1||d==8)
        return d;
        if(d==2)
        return 5;
        if(d==5)
        return 2;
        if(d==6)
        return 9;
        if(d==9)
        return 6;
        else
        return -1;
    }
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int num=i;
            boolean placed=false;
            int newNum=0;

            while(num!=0){
                int d=num%10;
                int dig=rotate(d);
                if(dig==-1||dig==d){
                    placed=false;
                    break;
                }
                else
                placed=true;
                num=num/10;
            }
            if(placed)
            ans++;
        }
        return ans;
    }
}