class Solution {
    String[] dp;
    int t;
    public String compare(String s1,String s2){
       if(s1.length()>s2.length())
       return s1;
       else if(s2.length()>s1.length())
       return s2;
       for(int i=0;i<s1.length();i++){
        char c1=s1.charAt(i);
        char c2=s2.charAt(i);
        if(c1>c2)
        return s1;
        else if(c2>c1)
        return s2;
       }
       return s1;
    }
    public String find(int[] a,int x){
        if(x>t)
        return "0";
        if(x==t)
        return "";
        String res="0";
        if(!dp[x].equals("a"))
        return dp[x];
        for(int i=0;i<9;i++){
            String s=find(a,x+a[i]);
            if(s.equals("0"))
            continue;
            s=(char)(i+1+'0')+s;
            res=compare(res,s); 
        }
        return dp[x]=res;
    }
    public String largestNumber(int[] cost, int target) {
        dp=new String[target+1];
        Arrays.fill(dp,"a");
        t=target;
        return find(cost,0);
    }
}