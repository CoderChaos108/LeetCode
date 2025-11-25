class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0||k%5==0)
        return -1;
        HashSet<Integer> seen=new HashSet<Integer>();
        int n=1;
        int size=1;
        while(n<k){
            size++;
            n=n*10+1;
        }
        n=n%k;
        while(true){
            if(!seen.add(n))
            return -1;
            n=n%k;
            if(n==0)
            return size;
            size++;
            n=n*10+1;
        }
    }
}