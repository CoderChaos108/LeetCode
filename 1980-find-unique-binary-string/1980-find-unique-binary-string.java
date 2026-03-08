class Solution {
    HashSet<String> set=new HashSet<>();
    int n;
    String ans;
    public void find(StringBuilder sb){
        if(sb.length()==n){
            String s=sb.toString();
            if(!set.contains(s))
            ans=s;
            return;
        }
        sb.append('0');
        find(sb);
        sb.setLength(sb.length()-1);
        sb.append('1');
        find(sb);
        sb.setLength(sb.length()-1);
    }
    public String findDifferentBinaryString(String[] nums) {
        n=nums.length;
        for(String s:nums)
        set.add(s);
        find(new StringBuilder());
        return ans;
    }
}