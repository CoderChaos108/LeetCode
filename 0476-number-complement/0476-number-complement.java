class Solution {
    public int findComplement(int num) {
       StringBuilder binary=new StringBuilder();
       while(num!=0){
        binary.append(String.valueOf(num%2));
        num=num/2;
       }
       StringBuilder sb=new StringBuilder();
       for(int i=binary.length()-1;i>=0;i--){
        if(binary.charAt(i)=='0')
        sb.append('1');
        else
        sb.append('0');
       }
       return Integer.parseInt(sb.toString(),2);
    }
}