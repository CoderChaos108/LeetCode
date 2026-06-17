class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> list=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++)
            list.add(new int[]{arr[i],arr[j]});
        }
        Collections.sort(list,(a,b)->{
            double x=a[0];
            x=x/a[1];
            double y=b[0];
            y=y/b[1];
            return Double.compare(x,y);
        });
        return list.get(k-1);
    }
}