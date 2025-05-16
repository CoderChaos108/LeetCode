class Solution {
    static int minSteps(String s, String t) {
        int count=0;
        int l=s.length();
        int[] fs=new int[26];
        int[] ft=new int[26];
        for(int i=0;i<l;i++){
            fs[s.charAt(i)-'a']++;
            ft[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            count=count+Math.abs(fs[i]-ft[i]);
        }
        return count/2;
    }
}