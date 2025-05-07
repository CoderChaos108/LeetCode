class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int x=0;
        while(num1.charAt(x)!='+')
        x++;
        int a=Integer.valueOf(num1.substring(0,x));
        int b=Integer.valueOf(num1.substring(x+1,num1.length()-1));
        x=0;
        while(num2.charAt(x)!='+')
        x++;
        int c=Integer.valueOf(num2.substring(0,x));
        int d=Integer.valueOf(num2.substring(x+1,num2.length()-1));
        int Re=(a*c-b*d);
        int Im=(a*d+b*c);
        num1=String.valueOf(Re);
        num2=String.valueOf(Im);
        return (num1+"+"+Im+"i");
    }
}