class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        StringBuilder sb=new StringBuilder(stones);
        int c=0;
        for(int i=0;i<jewels.length();i++){
           for(int j=0;j<sb.length();j++){
            if(jewels.charAt(i)==sb.charAt(j)){
                c++;
                sb.delete(j,j+1);
                j--;
            }
           } 
        }
        return c;
    }
}