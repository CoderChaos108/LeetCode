class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int[] b=new int[arr.length];
         for(int i=0;i<arr.length;i++)
         b[i]=arr[i];
        Arrays.sort(arr);
        int rank=1;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i]))
            hm.put(arr[i],rank++);
        }
        int[] a=new int[arr.length];
        for(int i=0;i<b.length;i++)
        a[i]=hm.get(b[i]);
        return a;
    }
}