class Solution {
    public int func(String s){
        char c='z';
        int k=0;
            for(int j=0;j<s.length();j++)
            c=(char)Math.min(c,s.charAt(j));
            for(int j=0;j<s.length();j++){
                if(c==s.charAt(j))
                k++;
            }
            return k;
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] f=new int[words.length];
        for(int i=0;i<words.length;i++){
            String s=words[i];
            f[i]=func(s);
        }
        Arrays.sort(f);
        int[] a=new int[queries.length];
        int idx=0;
        for(String s:queries){
            int lim=func(s);
            int l=0;
            int c=0;
            int r=words.length-1;
            int t=r+1;
            while(l<=r){
                int m=(l+r)/2;
                int w=f[m];
                if(w<=lim){
                    l=m+1;
                }
                else{
                    t=Math.min(t,m);
                    r=m-1;
                }
            }
            a[idx++]=words.length-t;
        }
        return a;
    }
}