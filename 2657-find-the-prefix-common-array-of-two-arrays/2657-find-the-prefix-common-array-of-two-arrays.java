class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> a=new HashSet<>();
        HashSet<Integer> b=new HashSet<>();
        HashSet<Integer> seen=new HashSet<>();
        int[] ans=new int[A.length];
        for(int i=0;i<A.length;i++){
            a.add(A[i]);
            b.add(B[i]);
            if(a.contains(B[i]))
            seen.add(B[i]);
            if(b.contains(A[i]))
            seen.add(A[i]);
            ans[i]=seen.size();
        }
        return ans;
    }
}