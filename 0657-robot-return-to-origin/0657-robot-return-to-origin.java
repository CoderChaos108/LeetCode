class Solution {
    public boolean judgeCircle(String moves) {
        int v=0;
        int h=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U')
            v++;
            else if(moves.charAt(i)=='D')
            v--;
            else if(moves.charAt(i)=='R')
            h++;
            else
            h--;
            if(Math.abs(h)+(Math.abs(v))>moves.length()-1-i)
            return false;
        }
        if(v==0&&h==0)
        return true;
        return false;
    }
}