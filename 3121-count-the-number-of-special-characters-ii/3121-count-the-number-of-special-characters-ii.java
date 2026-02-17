class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] upper=new boolean[26];
        boolean[] lower=new boolean[26];
        boolean[] special=new boolean[26];
        Arrays.fill(special,true);
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(Character.isUpperCase(c)){
                int idx=c-'A';
                upper[idx]=true;
            }
            else{
                int idx=c-'a';
                lower[idx]=true;
                if(upper[idx])
                special[idx]=false;
            }
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(special[i]&&upper[i]&&lower[i])
            ans++;
        }
        return ans;
    }
}