class Solution {
    public boolean isPrime(String s){
        int n=Integer.valueOf(s);
        if(n==1||n==0)
        return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
    public boolean completePrime(int num) {
        String s=String.valueOf(num);
        for(int i=1;i<s.length();i++){
            String t=s.substring(0,i);
            if(!isPrime(t))
            return false;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.insert(0,s.charAt(i));
            String t=sb.toString();
            if(!isPrime(t))
            return false;
        }
        return true;
    }
}