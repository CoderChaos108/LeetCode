class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int f=flowerbed.length;
        for(int i=0;i<f;i++){
            if(flowerbed[i]==1)
            continue;
            if(f==1){
                n--;
                continue;
            }
            if(i==0&&flowerbed[1]==0){
                flowerbed[0]=1;
                n--;
                continue;
            }
            if(i==f-1&&flowerbed[f-2]==0){
                flowerbed[i]=1;
                n--;
                continue;
            }
            if(i==0||i==f-1)
            continue;
            if(flowerbed[i-1]==0&&flowerbed[i+1]==0){
                n--;
                flowerbed[i]=1;
            }
        }
        return n<=0;
    }
}