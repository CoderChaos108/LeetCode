class Solution {
    public int maxFreqSum(String s) {
        int[] a=new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        int vf=0;
        int cf=0;
        for(int i=0;i<26;i++){
            if(i==0||i==4||i=='i'-'a'||i=='o'-'a'||i=='u'-'a'){
                vf=Math.max(vf,a[i]);
            }
            else
            cf=Math.max(cf,a[i]);
        }
        return vf+cf;
    }
}