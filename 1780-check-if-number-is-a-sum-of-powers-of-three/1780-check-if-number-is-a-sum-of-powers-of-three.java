class Solution {
    List<Integer> list=new ArrayList<>();
    HashMap<String,Boolean> dp=new HashMap<>();

    public boolean find(int n,int l){
        if(n==0)
        return true;

        if(n<0||l<0)
        return false;

        String key=n+","+l;

        if(dp.containsKey(key))
        return dp.get(key);

        boolean res=find(n-list.get(l),l-1);

        if(!res)
        res=find(n,l-1);

        dp.put(key,res);

        return res;
    }

    public boolean checkPowersOfThree(int n) {
        long p=1;

        while(p<=n){
            list.add((int)p);
            p=p*3;
        }

        return find(n,list.size()-1);
    }
}