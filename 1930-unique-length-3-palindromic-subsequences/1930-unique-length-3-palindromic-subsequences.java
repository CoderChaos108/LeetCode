class Solution {
    public int countPalindromicSubsequence(String s) {
       int[] first=new int[26];
       int[] last=new int[26];
       int ans=0;
       for(int i=0;i<26;i++){
        first[i]=-1;
       }
       for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(first[idx]==-1)
            first[idx]=i;
            last[idx]=i;
       }
       for(int i=0;i<26;i++){
            int start=first[i];
            int end=last[i];
            boolean[] seen=new boolean[26];
            int seenFig=0;
            for(int j=start+1;j<end;j++){
                if(seenFig==26)
                break;
                int idx=s.charAt(j)-'a';
                if(!seen[idx]){
                    seen[idx]=true;
                    seenFig++;
                    ans++;
                }
            }
       }
       return ans; 
    }
}