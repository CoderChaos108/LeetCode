class RandomizedSet {
    HashMap <Integer,Integer> hm;
    ArrayList<Integer> list;
    Random rand;
    public RandomizedSet() {
        hm=new HashMap<>();
        list=new ArrayList<Integer>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        boolean notcontains=!hm.containsKey(val);
        if(notcontains){
        hm.put(val,hm.size());
        list.add(val);
        }
        return notcontains;
    }
    
    public boolean remove(int val) {
        boolean contains=hm.containsKey(val);
        if(contains){
            hm.put(list.get(list.size()-1),hm.get(val));
            list.set(hm.get(val),list.get(list.size()-1));
            list.remove(list.size()-1);
            hm.remove(val);
        }
        return contains;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */