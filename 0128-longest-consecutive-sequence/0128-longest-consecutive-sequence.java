class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> t=new HashSet<>();
        for(int i:nums)
        set.add(i);
        int l=0;
        int r=0;
        int c=0;
        int k=0;
        for(int i:set){
            c=1;
            if(t.contains(i))
            continue;
            t.add(i);
            l=i;
            r=i;
            while(set.contains(l-1)){
                c++;
                l--;
                t.add(l);
            }
            while(set.contains(r+1)){
                c++;
                r++;
                t.add(r);
            }
            if(k<c)
            k=c;

        }
        return k;
    }
}