class Solution {
    public int distributeCandies(int[] candyType) {
        int limit=candyType.length/2;
        HashSet<Integer> set=new HashSet<>();
        for(int i:candyType)
        set.add(i);
        return Math.min(set.size(),limit);
    }
}