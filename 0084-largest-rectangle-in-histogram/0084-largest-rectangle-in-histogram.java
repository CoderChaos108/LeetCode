class Solution {
    public int largestRectangleArea(int[] heights) {
        List<int[]> list=new ArrayList<>();
        int ans=0;
        for(int i=0;i<heights.length;i++){
                int h=heights[i];
                int minJ=i;
                while(list.size()>0&&list.get(list.size()-1)[0]>h){
                    int[] a=list.get(list.size()-1);
                    int height=a[0];
                    int j=a[1];
                    minJ=Math.min(minJ,j);
                    ans=Math.max(ans,(i-j)*height);
                    list.remove(list.size()-1);
                }
                if(h==0)
                continue;
                list.add(new int[]{h,minJ});
        }
            int n=heights.length;
            while(list.size()!=0){
                int[] a=list.get(list.size()-1);
                int h=a[0];
                int j=a[1];
                ans=Math.max(ans,(n-j)*h);
                list.remove(list.size()-1);
            }
        return ans;
    }
}