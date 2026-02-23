class Solution {
    HashSet<String> set=new HashSet<>();
    public boolean hasAllCodes(String s, int k) {
            int l=0;
            int r=k;
            while(r<=s.length()){
                String str=s.substring(l,r);
                l++;
                r++;
                set.add(str);
            }
            return set.size()==(int)(Math.pow(2,k));
    }
}