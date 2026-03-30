class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] even1=new int[26];
        int[] even2=new int[26];
        int[] odd1=new int[26];
        int[] odd2=new int[26];
        for(int i=0;i<s1.length();i++){
             int idx=s1.charAt(i)-'a';
            if(i%2==0){
                even1[idx]++;
            }
            else
            odd1[idx]++;
        }
        for(int i=0;i<s2.length();i++){
             int idx=s2.charAt(i)-'a';
            if(i%2==0){
                even2[idx]++;
            }
            else
            odd2[idx]++;
        }
        for(int i=0;i<26;i++){
            if(odd1[i]!=odd2[i]||even1[i]!=even2[i])
            return false;
        }
        return true;
    }
}