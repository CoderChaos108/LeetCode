class Solution {
    int n;
    HashMap<List<Integer>,Integer> hm=new HashMap<>();
    public int find(List<Integer> price,List<List<Integer>> special,List<Integer> list){
        if(hm.containsKey(list)){
            if(hm.get(list)==-1)
            return -1;
            return hm.get(list);
        }
        hm.put(list,-1);
        int buyAll=0;
        for(int i=0;i<n;i++)
        buyAll=buyAll+list.get(i)*price.get(i);
        int ans=buyAll;
        for(List<Integer> deal:special){
            int cost=deal.get(n);
            boolean valid=true;
            List<Integer> newList=new ArrayList<>();
            for(int i=0;i<n;i++){
                int left=list.get(i)-deal.get(i);
                if(left<0){
                    valid=false;
                    break;
                }
                newList.add(left);
            }
            if(!valid)
            continue;
            int res=cost+find(price,special,newList);
            ans=Math.min(ans,res);
        }
        hm.put(list,ans);
        return ans;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n=price.size();
        return find(price,special,needs);
    }
}