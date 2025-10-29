class Solution {
    public boolean check(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
        return true;
        return false;
    }
    public int beautifulSubstrings(String s, int k) {
        int ans=0;
        for(int i=0;i<s.length()-1;i++){
            int vows=0;
            if(check(s.charAt(i)))
            vows++;
            for(int j=i+1;j<s.length();j++){
                if(check(s.charAt(j)))
                vows++;
                int cons=j-i+1-vows;
                if(vows==cons&&(cons*vows)%k==0)
                ans++;
            }
        }
        return ans;
    }
}