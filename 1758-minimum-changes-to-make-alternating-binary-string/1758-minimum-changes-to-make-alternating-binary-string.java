class Solution {
    public int counter(int i,boolean zero,String s){
        if(i>=s.length())
        return 0;
        int ret=0;
        char c=s.charAt(i);
        if(zero&&c=='1'){
            ret=1;
        }
        else if(!zero&&c=='0')
        ret=1;
        return ret+counter(i+1,!zero,s);
    }
    public int minOperations(String s) {
        return Math.min((counter(0,true,s)),(counter(0,false,s)));
    }
}