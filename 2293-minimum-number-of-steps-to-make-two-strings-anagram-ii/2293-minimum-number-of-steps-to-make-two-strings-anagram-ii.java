class Solution {
    public int minSteps(String s, String t) {
        String k;
        if(s.length()<t.length()){
            k=t;
            t=s;
            s=k;
        }
        int[] as=new int[26];
        int[] at=new int[26];
        int l=t.length();
        for(int i=0;i<l;i++){
            as[s.charAt(i)-'a']++;
            at[t.charAt(i)-'a']++;
        }
        l=s.length();
        for(int i=t.length();i<l;i++){
            as[s.charAt(i)-'a']++;
        }
        int c=0;
        for(int i=0;i<26;i++)
        c=c+Math.abs(as[i]-at[i]);
        return c;
    }
}