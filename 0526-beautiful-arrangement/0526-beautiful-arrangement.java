class Solution {
    int n;
    boolean[] seen;
    int ans=0;
    public void find(int size){
        if(size==n){
            ans++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(seen[i-1])
            continue;
            if(i%(size+1)!=0&&(size+1)%i!=0)
            continue;
            seen[i-1]=true;
            find(size+1);
            seen[i-1]=false;
        }
    }

    public int countArrangement(int n2) {
        n=n2;
        seen=new boolean[n];
        find(0);
        return ans;
    }
}