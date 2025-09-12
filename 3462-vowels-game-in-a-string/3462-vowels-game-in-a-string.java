class Solution {
    public boolean doesAliceWin(String s) {
        boolean[] arr=new boolean[26];
        arr[0]=true;
        arr[4]=true;
        arr['i'-'a']=true;
        arr['o'-'a']=true;
        arr['u'-'a']=true;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(arr[s.charAt(i)-'a'])
            return true;
        }
        return false;
    }
}