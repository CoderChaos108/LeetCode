class Solution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int l=candyType.length;
        int limit=l/2;
        int count=1;
        for(int i=1;i<l;i++){
            if(candyType[i]!=candyType[i-1])
            count++;
            if(count>=limit)
            return limit;
        }
        return count;
    }
}