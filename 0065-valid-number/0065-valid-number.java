class Solution {
    public boolean isNumber(String s) {
        int l=0,r=s.length()-1;
        while(l<=r){
            char cl=s.charAt(l),cr=s.charAt(r);
            if(Character.isLetter(cl)){
                if(cl!='e'&&cl!='E')
                return false;
            }
            if(l!=r&&Character.isLetter(cr)){
                if(cr!='e'&&cr!='E')
                return false;
            }
            l++;
            r--;
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