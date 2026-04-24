class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int x=0;
        int rand=0;
        for(int i=0;i<moves.length();i++){
            char c=moves.charAt(i);
            if(c=='L')
            x--;
            else if(c=='R')
            x++;
            else{
                rand++;
            }
        }
        if(x>=0)
        x=x+rand;
        else
        x=x-rand;
        return Math.abs(x);
    }
}