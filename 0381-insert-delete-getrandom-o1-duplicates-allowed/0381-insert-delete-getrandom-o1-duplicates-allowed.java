class RandomizedCollection{
    ArrayList<Integer>list;
    Random rand;
    HashMap<Integer,ArrayList<Integer>>hm;

    public RandomizedCollection(){
        rand=new Random();
        list=new ArrayList<>();
        hm=new HashMap<>();
    }

    public boolean insert(int val){
        boolean res=!hm.containsKey(val);
        hm.putIfAbsent(val,new ArrayList<>());
        hm.get(val).add(list.size());
        list.add(val);
        return res;
    }

    public boolean remove(int val){
        if(!hm.containsKey(val))return false;
        int i=hm.get(val).remove(hm.get(val).size()-1);
        int j=list.size()-1;
        int v=list.get(j);
        list.set(i,v);
        if(i!=j){
            for(int k=0;k<hm.get(v).size();k++){
                if(hm.get(v).get(k)==j){
                    hm.get(v).set(k,i);
                    break;
                }
            }
        }
        list.remove(j);
        if(hm.get(val).isEmpty())hm.remove(val);
        return true;
    }

    public int getRandom(){
        return list.get(rand.nextInt(list.size()));
    }
}
