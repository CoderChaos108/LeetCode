class Solution {
    public int hIndex(int[] citations) {
        int l=0;
        for(int i:citations){
            if(l<i)
            l=i;
        }
        int[] f=new int[l+1];
        for(int i:citations){
            f[i]++;
        }
        l=0;
        for(int i=0;i<f.length;i++){
            for(int j=0;j<f[i];j++){
                if(citations.length-l<=i)
                return citations.length-l;
                l++;
            }
        }
        return 0;
    }
}