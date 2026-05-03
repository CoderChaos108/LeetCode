class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length()!=s.length())
        return false;
        s=s+s;
        StringBuilder sb=new StringBuilder();
        int n=goal.length();
        int l=0;
        int r=n;
        while(r<s.length()){
            String t=s.substring(l,r);
            if(t.equals(goal))
            return true;
            l++;
            r++;
        }
        return false;
    }
}