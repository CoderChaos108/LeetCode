class Solution {
    public int[] interval(int[] a,int[] b){
        int[] ans=new int[2];
        if(a[1]<b[0]||b[1]<a[0])
        return new int[0];
        ans[0]=Math.max(a[0],b[0]);
        ans[1]=Math.min(a[1],b[1]);
        return ans; 
    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        List<int[]> list=new ArrayList<>();
        while(i<firstList.length&&j<secondList.length){
            int[] a=firstList[i];
            int[] b=secondList[j];
            int[] inter=interval(a,b);
            if(inter.length!=0)
            list.add(inter);
            if(a[1]<b[1])
            i++;
            else if(a[1]>b[1])
            j++;
            else{
                i++;
                j++;
            }
        }
        int[][] ans=new int[list.size()][2];
        int itr=0;
        for(int[] ints:list){
            ans[itr++]=ints;
        }
        return ans;
    }
}