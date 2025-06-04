class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p=0;
        int q=0;
        int c=0;
        int len1=g.length;
        int len2=s.length;
        while(p<len1&&q<len2){
            if(g[p]<=s[q]){
                p++;
                q++;
                c++;
            }
            else
            q++;
        
        }
        return c;
    }
}