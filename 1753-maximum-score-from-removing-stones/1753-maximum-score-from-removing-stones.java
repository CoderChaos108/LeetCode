class Solution {
    public int maximumScore(int a, int b, int c) {
        List<Integer> list=Arrays.asList(a,b,c);
        Collections.sort(list);
        int ans=0;
        while(list.get(1)!=0){
            ans++;
            list.set(2,list.get(2)-1);
            list.set(1,list.get(1)-1);
            Collections.sort(list);
        }
        return ans;
    }
}