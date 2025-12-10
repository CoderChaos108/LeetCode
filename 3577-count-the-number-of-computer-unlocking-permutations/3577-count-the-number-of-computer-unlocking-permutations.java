class Solution {
    public int factorial(int n){
        long ans=1;
        for(int i=2;i<=n;i++)
        ans=(ans*i)%1000000007;
        return (int)ans;
    }
    public int countPermutations(int[] complexity) {
        if(complexity[0]==complexity[1])
        return 0;
        int root=complexity[0];
        for(int i=1;i<complexity.length;i++){
            if(complexity[i]<=root)
            return 0;
        }
        return factorial(complexity.length-1);
    }
}