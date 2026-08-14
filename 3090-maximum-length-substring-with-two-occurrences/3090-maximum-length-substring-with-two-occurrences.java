class Solution {
    public int maximumLengthSubstring(String s) {
        int[] a=new int[26];
        int n=s.length();
        int ans=0;
        int l=0;
        for(int r=0;r<n;r++){
            int c=s.charAt(r)-'a';
            a[c]++;
            while(a[c]==3){
                a[s.charAt(l)-'a']--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}