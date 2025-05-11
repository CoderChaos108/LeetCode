class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<stones.length();i++){
            if(!hm.containsKey(stones.charAt(i)))
            hm.put(stones.charAt(i),1);
            else
            hm.put(stones.charAt(i),hm.get(stones.charAt(i))+1);
        }
        int c=0;
        for(int i=0;i<jewels.length();i++){
            c=c+hm.getOrDefault(jewels.charAt(i),0);
            
        }
        return c;
    }
}