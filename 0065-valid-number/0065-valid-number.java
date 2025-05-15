class Solution {
    public boolean isNumber(String s) {
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))&&s.charAt(i)!='e'&&s.charAt(i)!='E')
            return false;
        }
        try{
        Double d=Double.valueOf(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}