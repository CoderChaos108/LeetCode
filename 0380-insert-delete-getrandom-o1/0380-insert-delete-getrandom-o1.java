class RandomizedSet {
    HashMap<Integer,Integer> hm;
    HashMap<Integer,Integer> valkey;
    public RandomizedSet() {
        hm=new HashMap<>();
        valkey=new HashMap<>();
    }   
    public boolean insert(int val) {
        boolean notcontains=!valkey.containsKey(val);
        if(notcontains){
            hm.put(hm.size(),val);
            valkey.put(val,hm.size()-1);
        }
        return notcontains;
    }
    
    public boolean remove(int val) {
        boolean contains=valkey.containsKey(val);
        if(contains){
            hm.put(valkey.get(val),hm.get(hm.size()-1));
            hm.remove(hm.size()-1);
            valkey.put((hm.get(valkey.get(val))),valkey.get(val));
            valkey.remove(val);
        }
        return contains;
    } 
    public int getRandom() {
        Random rand=new Random();
        return hm.get(rand.nextInt(hm.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */