class Solution {
    public int compareVersion(String v1, String v2) {
        int p=0;
        int q=0;
        int a=0;
        int b=0;
        int l1=v1.length();
        int l2=v2.length();
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        while(p<l1||q<l2){
            while(p<l1&&v1.charAt(p)!='.'){
            s1.append(v1.charAt(p));
            p++;
            }
            while(q<l2&&v2.charAt(q)!='.'){
            s2.append(v2.charAt(q));
            q++;
            }
            if(s1.length()!=0)
            a=Integer.valueOf(s1.toString());
            else
            a=0;
            if(s2.length()!=0)
            b=Integer.valueOf(s2.toString());
            else
            b=0;
            if(a>b)
            return 1;
            if(b>a)
            return -1;
            s1.setLength(0);
            s2.setLength(0);
            p++;
            q++;
        }
        return 0;
    }
}