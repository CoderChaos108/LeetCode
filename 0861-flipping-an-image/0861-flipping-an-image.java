class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int l=0;
        int r=0;
        int t=0;
        for(int i=0;i<image.length;i++){
            l=0;
            r=image.length-1;
            while(l<=r){  
                if(image[i][l]==0)
                image[i][l]=1;
                else
                image[i][l]=0;
                if(l==r)
                break; 
                if(image[i][r]==0)
                image[i][r]=1;
                else
                image[i][r]=0;
                t=image[i][r];
                image[i][r]=image[i][l];
                image[i][l]=t;
                l++;
                r--;
            }
        }
        return image;
    }
}