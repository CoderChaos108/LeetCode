class MapSum {
    HashMap<String,Integer> hm;
    ArrayList<String> list;
    int sum;
    public MapSum() {
        sum=0;
        hm=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public void insert(String key, int val) {
        if(!hm.containsKey(key))
        list.add(key);     
        hm.put(key,val);
    }
    
    public int sum(String prefix) {
        sum=0;
        int l=prefix.length();
        for(String s:list){
            if(l>s.length())
            continue;
            if(s.substring(0,l).equals(prefix))
            sum=sum+hm.get(s);

        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */