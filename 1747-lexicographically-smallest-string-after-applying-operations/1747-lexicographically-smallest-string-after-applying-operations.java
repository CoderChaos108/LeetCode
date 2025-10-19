class Solution {
    HashSet<String> seen=new HashSet<>();
    int a,b;
    String ans="";
    
    public void update(String s){
        if(ans.equals("")) {
            ans=s;
            return;
        }
        int size=Math.min(ans.length(),s.length());
        for(int i=0;i<size;i++){
            char c1=ans.charAt(i);
            char c2=s.charAt(i);
            if(c2<c1){
                ans=s;
                return;
            }
            else if(c1<c2)
            return;
        }
        if(s.length()<ans.length())
        ans=s;
    }

    public void find(StringBuilder sb){
        String str=sb.toString();
        if(!seen.add(str))
        return;
        update(str);

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
