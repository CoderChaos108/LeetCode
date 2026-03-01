class Solution {
    public int minPartitions(String n) {
        int max=0;
        int len=n.length();
        for(int i=0;i<len;i++){
        max=Math.max(max,n.charAt(i)-'0');
        if(max==9)
        return max;
        }
        return max;
    }
}