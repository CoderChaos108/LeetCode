class Solution {
    int n;
    boolean[] seen;
    int ans=0;
    public void find(List<Integer> list){
        if(list.size()==n){
            ans++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(seen[i-1])
            continue;
            int size=list.size()+1;
            if(i%size!=0&&size%i!=0)
            continue;
            list.add(i);
            seen[i-1]=true;
            find(list);
            list.remove(list.size()-1);
            seen[i-1]=false;
        }
    }

    public int countArrangement(int n2) {
        n=n2;
        seen=new boolean[n];
        find(new ArrayList<>());
        return ans;
    }
}