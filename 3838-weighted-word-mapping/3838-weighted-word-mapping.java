class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans="";
        for(String s:words){
            int sum=0;
            for(int i=0;i<s.length();i++){
                sum=sum+weights[s.charAt(i)-'a'];
                sum=sum%26;
            }
            sum=25-sum;
            ans=ans+((char)(sum+'a'));
        }
        return ans;
    }
}