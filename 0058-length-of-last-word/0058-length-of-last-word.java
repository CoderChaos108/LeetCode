class Solution {
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        boolean found=false;
        int c=0;
        while(i!=-1){
            if(s.charAt(i)==' '&&found)
            break;
            if(Character.isLetter(s.charAt(i))){
            found=true;
            c++;
            }
            i--;
        }
        return c;
    }
}