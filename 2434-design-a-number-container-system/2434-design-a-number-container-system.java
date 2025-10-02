class NumberContainers {
    HashMap<Integer,Integer> hm;
    HashMap<Integer,TreeSet<Integer>> im;
    public NumberContainers() {
        hm=new HashMap<>();
        im=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(hm.containsKey(index))
        im.get(hm.get(index)).remove(index);
        hm.put(index,number);
        if(!im.containsKey(number))
        im.put(number,new TreeSet<>());
        im.get(number).add(index);
    }
    
    public int find(int number) {
        if(!im.containsKey(number)||im.get(number).size()==0)
        return -1;
        return im.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */