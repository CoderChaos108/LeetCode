class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int[] a=new int[3];
        int ans=0;
        for(int r=0;r<s.length();r++){
            a[s.charAt(r)-'a']++;
            while(a[0]>=1&&a[1]>=1&&a[2]>=1){
                ans=ans+(s.length()-r);
                a[s.charAt(l)-'a']--;
                l++;
            }
        }
       
        return ans;
    }
}