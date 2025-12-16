class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long ans=0;
        int i=0;
        boolean[] seen=new boolean[values.length];
        while(i>=0&&i<values.length&&!seen[i]){
            seen[i]=true;
            if(instructions[i].charAt(0)=='a'){
                ans=ans+values[i];
                i++;
            }
            else
            i=i+values[i];
        }
        return ans;
    }
}