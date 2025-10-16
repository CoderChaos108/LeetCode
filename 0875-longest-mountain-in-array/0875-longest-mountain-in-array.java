class Solution {
    public int longestMountain(int[] arr) {
        List<Integer> peaks=new ArrayList<>();
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i-1]&&arr[i+1]<arr[i])
            peaks.add(i);
        }
        int ans=0;
        for(int i:peaks){
            int val=i;
            int count=1;
            int itr=i-1;
            while(itr>=0&&arr[itr]<arr[itr+1]){
                count++;
                itr--;
            }
            itr=i+1;
            while(itr<arr.length&&arr[itr]<arr[itr-1]){
                itr++;
                count++;
            }
            ans=Math.max(count,ans);
        }
        return ans;
    }
}