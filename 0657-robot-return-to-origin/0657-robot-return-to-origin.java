class Solution {
    public boolean judgeCircle(String moves) {
        int v=0;
        int h=0;
        int l=moves.length();
        for(int i=0;i<l;i++){
            char c=moves.charAt(i);
            switch(c){
                case 'U':v++;
                break;
                case 'D':v--;
                break;
                case 'R':h++;
                break;
                case 'L':h--;
                break;
            }
        }
        if(v==0&&h==0)
        return true;
        return false;
    }
}