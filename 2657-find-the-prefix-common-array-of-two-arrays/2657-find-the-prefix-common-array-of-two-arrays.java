class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        boolean[] a = new boolean[51];
        boolean[] b = new boolean[51];
        boolean[] seen = new boolean[51];
        
        int count = 0;
        int[] ans = new int[A.length];
        
        for(int i = 0; i < A.length; i++){
            a[A[i]] = true;
            b[B[i]] = true;
            
            if(a[B[i]] && !seen[B[i]]) {
                seen[B[i]] = true;
                count++;
            }
            
            if(b[A[i]] && !seen[A[i]]) {
                seen[A[i]] = true;
                count++;
            }
            
            ans[i] = count;
        }
        
        return ans;
    }
}