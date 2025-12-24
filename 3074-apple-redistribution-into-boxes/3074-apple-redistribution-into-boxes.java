class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int apples=0;
        for(int i:apple)
        apples=apples+i;
        int i=capacity.length-1;
        while(apples>0){
            apples=apples-capacity[i];
            i--;
        }
        return capacity.length-i-1;
    }
}