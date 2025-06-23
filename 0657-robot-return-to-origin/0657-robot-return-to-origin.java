class Solution {
    public boolean judgeCircle(String moves) {
        int[] a={0,0};
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U')
            a[0]++;
            else if(moves.charAt(i)=='D')
            a[0]--;
            else if(moves.charAt(i)=='R')
            a[1]++;
            else
            a[1]--;
        }
        if(a[0]==0&&a[1]==0)
        return true;
        return false;
    }
}