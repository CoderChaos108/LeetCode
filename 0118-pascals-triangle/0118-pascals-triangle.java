class Solution {
    static int C(int u,int d){
        if(d==0||u==d)
        return 1;
        if(d>=u-d)
        d=u-d;
        long p=1;
        for(int i=0;i<d;i++){
            p=p*u;
            u--;
        }
        long q=1;
        while(d!=1){
            q=d*q;
            d--;
        }
        return (int)(p/q);

    }
    public List<List<Integer>> generate(int n) {
        ArrayList<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                list.add(C(i,j));
            }
            ans.add(list);
        }
        return ans;
    }
}