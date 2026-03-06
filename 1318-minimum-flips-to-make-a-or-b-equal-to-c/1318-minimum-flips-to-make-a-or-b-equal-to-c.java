class Solution {
    public int minFlips(int a, int b, int c) {
        String s1=Integer.toBinaryString(a);
        String s2=Integer.toBinaryString(b);
        String s3=Integer.toBinaryString(c);
        while(s1.length()!=32){
            s1='0'+s1;
        }
        while(s2.length()!=32){
            s2='0'+s2;
        }
        while(s3.length()!=32){
            s3='0'+s3;
        }
        int ans=0;
        for(int i=0;i<32;i++){
            if(s3.charAt(i)=='0'){
                if(s1.charAt(i)=='1')
                ans++;
                if(s2.charAt(i)=='1')
                ans++;
            }
            else{
                if(s1.charAt(i)=='0'&&s2.charAt(i)=='0')
                ans++;
            }
        }
        return ans;
    }
}