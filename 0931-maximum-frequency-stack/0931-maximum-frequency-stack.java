class FreqStack {
    HashMap <Integer,ArrayList<Integer>> hm;
    HashMap <Integer,Integer> fmap;
    int f;
    
    public FreqStack() {
        hm=new HashMap<>();
        fmap=new HashMap<>();
        f=0;
    }
    
    public void push(int val) {
        fmap.put(val,fmap.getOrDefault(val,0)+1);
        if(!hm.containsKey(fmap.get(val))){
            ArrayList<Integer> list=new ArrayList<Integer>();
            list.add(val);
            hm.put(fmap.get(val),list);
        }
        else{
            hm.get(fmap.get(val)).add(val);

        }
        if(fmap.get(val)>f)
        f=fmap.get(val);
    }
    
    public int pop() {
        ArrayList<Integer> list = hm.get(f);
        int x=list.get(list.size()-1);
        list.remove(list.size()-1);
        fmap.put(x,fmap.get(x)-1);
        if(fmap.get(x)==0)
        fmap.remove(x);
        if(list.size()==0){
            f--;
        }
        else{
            hm.put(f,list);
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */