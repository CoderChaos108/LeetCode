class Solution {
    public int reverseBits(int n) {
        String bin=Integer.toBinaryString(n);
        while(bin.length()!=32){
            bin="0"+bin;
        }
        String s="";
        for(int i=bin.length()-1;i>=0;i--)
        s=s+bin.charAt(i);
        return Integer.parseInt(s,2);
    }
}