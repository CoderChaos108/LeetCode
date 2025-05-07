class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int x=0;
        StringBuilder sb=new StringBuilder();
        while(num1.charAt(x)!='+')
        x++;
        int a=Integer.valueOf(num1.substring(0,x));
        int b=Integer.valueOf(num1.substring(x+1,num1.length()-1));
        x=0;
        while(num2.charAt(x)!='+')
        x++;
        int c=Integer.valueOf(num2.substring(0,x));
        int d=Integer.valueOf(num2.substring(x+1,num2.length()-1));
        sb.append(String.valueOf(a*c-b*d));
        sb.append("+");
        sb.append(String.valueOf(a*d+b*c));
        sb.append("i");
        return sb.toString();
    }
}