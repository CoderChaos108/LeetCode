class Solution {
    public boolean compare(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])
            return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        return false;
        int[] a=new int[26];
        int[] b=new int[26];
        for(int i=0;i<s1.length();i++){
            a[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s1.length()-1;i++){
            b[s2.charAt(i)-'a']++;
        }
        for(int i=s1.length()-1;i<s2.length();i++){
            b[s2.charAt(i)-'a']++;
            if(compare(a,b))
            return true;
            int itr=i-(s1.length()-1);
            b[s2.charAt(itr)-'a']--;
        }
        return false;
    }
}