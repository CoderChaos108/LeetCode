class Solution {
    public int smallestNumber(int n) {
      int i=2;
      while(i-1<n){
        i=i*2;
      }  
      return i-1;
    }
}