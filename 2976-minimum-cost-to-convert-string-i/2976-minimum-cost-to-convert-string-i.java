class Solution {
    public long minimumCost(String source,String target,char[] original,char[] changed,int[] cost){
        long[][] a=new long[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                a[i][j]=Long.MAX_VALUE/2;
            }
        }
        for(int i=0;i<26;i++)
        a[i][i]=0;
        for(int i=0;i<original.length;i++){
            a[original[i]-'a'][changed[i]-'a']=Math.min(a[original[i]-'a'][changed[i]-'a'],(long)cost[i]);

        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(a[i][k]!=Long.MAX_VALUE/2&&a[k][j]!=Long.MAX_VALUE/2)
                    a[i][j]=Math.min(a[i][j],a[i][k]+a[k][j]);
                }
            }
        }
        long ans=0;
        for(int i=0;i<source.length();i++){
            if(a[source.charAt(i)-'a'][target.charAt(i)-'a']==Long.MAX_VALUE/2)
            return -1;
            ans=ans+a[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        return ans;
    }
}
