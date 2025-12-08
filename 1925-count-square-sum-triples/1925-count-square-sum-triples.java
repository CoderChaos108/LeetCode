class Solution {
    public int countTriples(int n) {
        int ans=0;
        HashSet<Integer> squares=new HashSet<>();
        for(int i=1;i<=n;i++)
        squares.add(i*i);
        for(int i=1;i<=n;i++){
            for(int j=i+1;Math.sqrt(i*i+j*j)<=n&&j<=n;j++){
                if(squares.contains(i*i+j*j))
                ans++;
            }
        }
        return ans*2;
    }
}