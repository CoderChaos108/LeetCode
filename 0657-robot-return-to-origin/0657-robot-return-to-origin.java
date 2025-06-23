class Solution {
    public boolean judgeCircle(String moves) {
        int v=0;
        int h=0;
        int l=moves.length();
        for(int i=0;i<l;i++){
            char c=moves.charAt(i);
            if(c=='U')
            v++;
            else if(c=='D')
            v--;
            else if(c=='R')
            h++;
            else
            h--;
            if(Math.abs(h)+(Math.abs(v))>l-1-i)
            return false;
        }
        if(v==0&&h==0)
        return true;
        return false;
    }
}