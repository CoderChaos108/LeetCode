class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] a=new int[26];
        for(int i=0;i<text.length();i++){
            int idx=text.charAt(i)-'a';
            a[idx]++;
        }    
        a['l'-'a']/=2;
        a['o'-'a']/=2;
        int ans=Integer.MAX_VALUE;
        char[] arr=new char[]{'b','a','l','o','n'};
        for(char c:arr){
            ans=Math.min(ans,a[c-'a']);
        }
        return ans;
    }
}