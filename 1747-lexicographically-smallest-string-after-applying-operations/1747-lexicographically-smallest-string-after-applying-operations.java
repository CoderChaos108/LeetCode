class Solution {
    HashSet<String> seen=new HashSet<>();
    public String check(String s1,String s2){
        int size=Math.min(s1.length(),s2.length());
        for(int i=0;i<size;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1>c2)
            return s2;
            else if(c2>c1)
            return s1;
        }
        if(size==s1.length())
        return s1;
        else
        return s2;
    }
    int a,b;
    String ans="";
    public void find(StringBuilder sb){
        String str=sb.toString();
        if(!seen.add(str))
        return;
        ans=check(ans,str);

        for(int i=1;i<sb.length();i=i+2){
            sb.setCharAt(i,(char)(((sb.charAt(i)-'0'+a)%10)+'0'));
        }
        find(new StringBuilder(sb));
        for(int i=1;i<sb.length();i=i+2){
            sb.setCharAt(i,(char)(((sb.charAt(i)-'0'-a+10)%10)+'0'));
        }

        int n=sb.length();
        StringBuilder rotated=new StringBuilder();
        for(int i=0;i<n;i++){
            int idx=0;
            if(i-b>=0)
            idx=i-b;
            else
            idx=n+(i-b);
            rotated.append(sb.charAt(idx));
        }
        find(rotated);
    }
    public String findLexSmallestString(String s,int a,int b){
        this.a=a;
        this.b=b%s.length();
        ans=s;
        find(new StringBuilder(s));
        return ans;
    }
}
