class Solution {
    static int[][] recur(int[][] mat){
        ArrayList<int[]> list=new ArrayList<int[]>();
        boolean merged=false;// 1,7 2,6
        for(int i=0;i<mat.length;i++){
            if(i!=mat.length-1&&mat[i][1]>=mat[i+1][0]){
            list.add(new int[]{mat[i][0],Math.max(mat[i+1][1],mat[i][1])});
            merged=true;
            i=i+1;
            }
            else{
                list.add(new int[]{mat[i][0],mat[i][1]});
            }
        }
        if(merged==false)
        return list.toArray(new int[0][]);
        return recur(list.toArray(new int[0][]));
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1)
        return intervals;
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        return(recur(intervals));
    }
}