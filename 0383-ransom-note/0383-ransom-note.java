class Solution {
    public boolean canConstruct(String s1, String s2) {
        int[] a=new int[26];
        int l=s1.length();
        for(int i=0;i<l;i++){
            a[s1.charAt(i)-'a']++;
        }
        l=s2.length();
        for(int i=0;i<l;i++){
            a[s2.charAt(i)-'a']--;
        }
        for(int i:a){
            if(i>0)
            return false;
        }
        return true;
    }
}