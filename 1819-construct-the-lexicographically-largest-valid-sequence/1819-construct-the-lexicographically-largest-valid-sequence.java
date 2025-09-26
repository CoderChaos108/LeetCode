class Solution{
    int n;
    int[] a;
    boolean[] seen;

    public boolean backtrack(int pos){
        if(pos==a.length)
            return true;

        if(a[pos]!=0)
            return backtrack(pos+1);

        for(int i=n;i>=1;i--){
            if(seen[i])
                continue;

            if(i==1){
                a[pos]=1;
                seen[1]=true;
                if(backtrack(pos+1))
                    return true;
                a[pos]=0;
                seen[1]=false;
            }
            else{
                int idx=pos+i;
                if(idx>=a.length || a[pos]!=0 || a[idx]!=0)
                    continue;
                a[pos]=i;
                a[idx]=i;
                seen[i]=true;
                if(backtrack(pos+1))
                    return true;
                a[pos]=0;
                a[idx]=0;
                seen[i]=false;
            }
        }
        return false;
    }

    public int[] constructDistancedSequence(int n2){
        n=n2;
        a=new int[2*n-1];
        seen=new boolean[n+1];
        backtrack(0);
        return a;
    }
}
