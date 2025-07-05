class Solution {
    public int findLucky(int[] arr) {
        int c=-1;
        int[] a=new int[500];
        for(int i:arr){
            a[i-1]++;           
        }
        for(int i=0;i<arr.length;i++){
            if(a[i]==i+1)
            c=Math.max(c,i+1);
        }
        return c;
    }
}