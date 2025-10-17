class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] notPrime=new boolean[n+1];
        for(int i=2;i*i<=n;i++){
            for(int j=i*i;j<=n;j=j+i){
                notPrime[j]=true;
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> primes=new ArrayList<>();
        for(int i=2;i<notPrime.length;i++){ 
            if(!notPrime[i])
            primes.add(i);
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i:primes){
            set.add(i);
        }
        for(int i:primes){
            if(set.contains(n-i)){
                int a=Math.min(i,n-i);
                int b=n-a;
                set.remove(i);
                ans.add(Arrays.asList(a,b));
            }
        }
        return ans;
    }
}