class Solution {
    public char findKthBit(int n, int k) {
        String s="0";
        for(int i=1;i<n;i++){
            StringBuilder sb=new StringBuilder();

            for(int j=s.length()-1;j>=0;j--){
            char c='0';
            if(s.charAt(j)=='0')
            c='1';
            sb.append(c);
            }
            s=s+'1'+sb.toString();
        }
        return s.charAt(k-1);
    }
}