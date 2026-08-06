class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> list=new ArrayList<>();
        int n=rocks.length;
        for(int i=0;i<n;i++){
            list.add(capacity[i]-rocks[i]);
        }
        Collections.sort(list);
        int ans=0;
        int left=additionalRocks;
        for(int i=0;i<n;i++){
            if(list.get(i)>left)
            break;
            ans++;
            left=left-list.get(i);
        }
        return ans;
    }
}