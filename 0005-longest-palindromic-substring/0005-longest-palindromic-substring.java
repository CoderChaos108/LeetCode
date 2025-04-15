class Solution {
    static boolean check(String str){
        String t="";
        if(str.length()%2==0){
            for(int i=str.length()-1;i>=str.length()/2;i--){
                if(str.charAt(i)!=str.charAt(str.length()-i-1))
                return false;
            }           
        }
        else{
            for(int i=str.length()-1;i>str.length()/2;i--){
                if(str.charAt(i)!=str.charAt(str.length()-i-1))
                return false;
            }     
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String l=s.charAt(0)+"";
        for(int i=0;i<s.length()-l.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(j-i+1<=l.length())
                continue;
                if(check(s.substring(i,j+1))==true){
                l=s.substring(i,j+1);
            }

        }
       
    }
    return l;
}
}