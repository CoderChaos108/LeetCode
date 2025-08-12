class Solution {
    public class Pair{
        double val;
        String pal;
        public Pair(double val){
            this.val=val;
            pal="";
        }
    }
    HashSet<String> seen=new HashSet<>();
    HashMap<String,List<Pair>> hm=new HashMap<>();
    public double dfs(String a,String target){
        if(!hm.containsKey(a)||seen.contains(a))
        return -1;
        if(target.equals(a))
        return 1;
        seen.add(a);
        double d=1;
        for(Pair p:hm.get(a)){
            d=p.val*dfs(p.pal,target);
            if(d>=0)
            return d;
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int k=0;
        for(List<String> list:equations){
            String x=list.get(0);
            String y=list.get(1);
            double div=values[k];
            k++;
            if(!hm.containsKey(x))
            hm.put(x,new ArrayList<>());
            if(!hm.containsKey(y))
            hm.put(y,new ArrayList<>());
            Pair p1=new Pair(div);
            Pair p2=new Pair(1/div);
            hm.get(x).add(p1);
            p1.pal=y;
            hm.get(y).add(p2);
            p2.pal=x;
        }  
        double[] ans=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String x=queries.get(i).get(0);
            String y=queries.get(i).get(1);
            if(!hm.containsKey(x)||!hm.containsKey(y))
            ans[i]=-1;
            else if(x.equals(y)){
                ans[i]=1;
            }
            else{
                ans[i]=dfs(x,y);
                seen.clear();
            }
        }
        return ans;
    }
}